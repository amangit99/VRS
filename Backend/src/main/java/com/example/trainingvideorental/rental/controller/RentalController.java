//package com.example.trainingvideorental.rental.controller;
//
//import com.example.trainingvideorental.Customer.model.Customer;
//import com.example.trainingvideorental.Customer.repository.CustomerRepository;
//import com.example.trainingvideorental.rental.model.Rental;
//import com.example.trainingvideorental.rental.repository.RentalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/rentals")
//
//public class RentalController {
//
//        @Autowired
//        RentalRepository rentalRepository;
//
//        @PostMapping
//        public Rental createRent(@RequestBody RentRequest rentRequest){
//            return rentalService.createRent(rentRequest);
//        }
//
//        @GetMapping
//        public List<Customer> getAllRentals(){
//
//            return CustomerRepository.getAllRent();
//        }
//
//        @PutMapping ("return/{id}")
//        public MovieReturnResponse returnMovie(@PathVariable Long id){
//
//            return  CustomerRepository.returnMovie(id);
//        }
//
//        @PutMapping
//        public Customer updateRentalDetails( @RequestBody UpdateRentalRequest updateRentalRequest) {
//
//            return CustomerRepository.updateRentalDetails(updateRentalRequest);
//        }
//
//        @GetMapping("rentalReport")
//        public Map<String, RentalReport> getRentalReport(){
//
//            return CustomerRepository.getRentalReport();
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id)
//        {
//            CustomerRepository.deleteById(id);
//            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
//        }
//    }
//
