package com.example.trainingvideorental.rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class UpdateRentalRequest {

    private Long rentalId;
    private Boolean isReturned;
    private LocalDate rentalExpiry;
    private double totalCost;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String movieTitle;
    private Long movieId;
    private String rentDate;

}
