package com.example.trainingvideorental.rental.api;


import com.example.trainingvideorental.rental.domain.service.RentalService;
import com.example.trainingvideorental.rental.dto.RentRequest;
import com.example.trainingvideorental.rental.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/rentals")

public class RentalController {


    @Autowired
    RentalService rentalService;

    @PostMapping
    public RentalResponse createRent(@RequestBody RentRequest rentRequest){
        return rentalService.createRent(rentRequest);
    }

    @GetMapping
    public List<RentalResponse> getAllRentals(){

        return rentalService.getAllRent();
    }

    @PutMapping ("/return/{id}")
    public MovieReturnResponse returnMovie(@PathVariable Long id){

        return  rentalService.returnMovie(id);
    }

    @PutMapping("/{id}")
    public RentalResponse updateRentalDetails( @RequestBody UpdateRentalRequest updateRentalRequest) {

        return rentalService.updateRentalDetails(updateRentalRequest);
    }

    @GetMapping("rentalReport")
    public Map<String, RentalReport> getRentalReport(){

        return rentalService.getRentalReport();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id)
    {
        rentalService.deleteById(id);
        Map<String, Boolean> response =  new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}

