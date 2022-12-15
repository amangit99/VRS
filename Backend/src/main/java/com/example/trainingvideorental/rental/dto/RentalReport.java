package com.example.trainingvideorental.rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalReport {
    private Integer totalQuantity;
    private Integer remainingQuantity;
    private List<String> overDueCustomers;
    private Integer onRent;
}
