package com.example.trainingvideorental.rental.dto;

import com.example.trainingvideorental.rental.domain.entity.Rental;
import org.jetbrains.annotations.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RentalResponse {

    private Long rentalId;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String movieTitle;
    private Long movieId;
    private Double totalCost;
    private String rentDate;
    private String rentalExpiry;
//    @Nullable
    private Boolean isReturned;

    public RentalResponse(@NotNull Rental rental){
        this.rentalId = rental.getRentalId();
        this.customerFirstName = rental.getCustomer().getFirstName();
        this.customerLastName = rental.getCustomer().getLastName();
        this.customerId = rental.getCustomer().getCustomer_id();
        this.movieTitle = rental.getMovie().getTitle();
        this.movieId = rental.getMovie().getMovie_Id();
        this.totalCost = rental.getTotalCost();
        this.rentDate= rental.getRentDate() == null? "" : rental.getRentDate().toString();
        this.isReturned =rental.getIsReturned();
        this.rentalExpiry = rental.getRentalExpiry().toString();


    }
}
