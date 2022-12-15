package com.example.trainingvideorental.rental.domain.service;


import com.example.trainingvideorental.Customer.model.Customer;
import com.example.trainingvideorental.Customer.repository.CustomerRepository;
import com.example.trainingvideorental.Movies.model.Movie;
import com.example.trainingvideorental.Movies.repository.MovieRepository;
import com.example.trainingvideorental.rental.domain.entity.Rental;
import com.example.trainingvideorental.rental.domain.repository.RentalRepository;
import com.example.trainingvideorental.rental.dto.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RentalServicelmpl implements RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public RentalResponse createRent(RentRequest rentRequest) {

        Customer customer = customerRepository.findById(rentRequest.getCustomerId())
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "customer doesn't exist please register"));

        Movie movie = movieRepository.findById(rentRequest.getMovieId())
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "movie doesn't exist"));

        if(movie.getRemainingQuantity() < 1){
            throw new IllegalArgumentException("movie is out of stock");
        }

        movie.setRemainingQuantity(movie.getRemainingQuantity() - 1);

        movieRepository.save(movie);

        Rental rental = new Rental();

        rental.setMovie(movie);

        rental.setCustomer(customer);

        rental.setRentalExpiry(rentRequest.getRentalExpiry());

        rental.setRentDate(rentRequest.getRentDate());

        rental.setTotalCost(rentRequest.getTotalCost());

        rental.setIsReturned(rentRequest.getIsReturned());

        rentalRepository.save(rental);

        return new RentalResponse(rental);
    }

    @Override
    public MovieReturnResponse returnMovie(Long rentId) {
        return rentalRepository.findById(rentId)
                .map(r -> {
                    if(r.getRentalExpiry().isBefore(LocalDate.now())){
                        return new MovieReturnResponse(10.0);
                    }
                    r.setIsReturned(true);
                    rentalRepository.save(r);
                    Movie movie = r.getMovie();
                        movie.setRemainingQuantity(movie.getRemainingQuantity() + 1);
                    if (movie.getTotalQuantity() < movie.getRemainingQuantity())
                    {
                        throw new IllegalArgumentException("error remaining Quantity is grater than Total Quantity ");
                    }

                        movieRepository.save(movie);
                    return new MovieReturnResponse(0.0);
                })
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "invalid rent id"));



    }

    @Override
    public RentalResponse updateRentalDetails(@NotNull UpdateRentalRequest updateRentalRequest) {

        Rental rental = rentalRepository.findById(updateRentalRequest.getRentalId())
                .orElseThrow(() -> new IllegalArgumentException("rent doesn't exist"));

        rental.setTotalCost(updateRentalRequest.getTotalCost());

        rental.setRentalExpiry(updateRentalRequest.getRentalExpiry());

        rental.setIsReturned(updateRentalRequest.getIsReturned());

        Rental save = rentalRepository.save(rental);

        return new RentalResponse(save);
    }

    @Override
    public List<RentalResponse> getAllRent() {
        return rentalRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Rental::getRentalId).reversed())
                .map(RentalResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public Void deleteById(Long id) {rentalRepository.deleteById(id);
        return null;
    }

    @Override
    public Map<String, RentalReport> getRentalReport() {

        return rentalRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(r -> r.getMovie().getTitle(),
                        Collectors.collectingAndThen(Collectors.toList(),
                                l -> {
                                    int onRent = l.size();
                                    List<String> overDueCustomers = l.stream().filter(r ->
                                                    r.getRentalExpiry().isBefore(LocalDate.now()))
                                            .map(r -> r.getCustomer().getFirstName().concat(" ")
                                                    .concat(r.getCustomer().getLastName()))
                                            .collect(Collectors.toList());

                                    Integer remainingQuantity = l.stream().findAny().get().getMovie().getRemainingQuantity();

                                    Integer totalQuantity = l.stream().findAny().get().getMovie().getTotalQuantity();

                                    RentalReport rentalReport = new RentalReport();
                                    rentalReport.setOverDueCustomers(overDueCustomers);
                                    rentalReport.setOnRent(onRent);
                                    rentalReport.setTotalQuantity(totalQuantity);
                                    rentalReport.setRemainingQuantity(remainingQuantity);
                                    return rentalReport;
                                }
                        )
                ));
    }

}
