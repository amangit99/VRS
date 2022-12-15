package com.example.trainingvideorental.rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RentRequest {

    private Long customerId;
    private Long movieId;
    private Double totalCost;
    private LocalDate rentalExpiry;
    private LocalDate rentDate;
    private Boolean IsReturned;

}
