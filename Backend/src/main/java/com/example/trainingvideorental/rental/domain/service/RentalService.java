package com.example.trainingvideorental.rental.domain.service;

import com.example.trainingvideorental.rental.dto.*;

import java.util.Map;
import java.util.List;

public interface RentalService {
    RentalResponse updateRentalDetails(UpdateRentalRequest updateRentalRequest);

    MovieReturnResponse returnMovie(Long id);

    RentalResponse createRent(RentRequest rentalRequest);

    List<RentalResponse> getAllRent();

    Void deleteById(Long id);

    Map<String, RentalReport> getRentalReport();
}
