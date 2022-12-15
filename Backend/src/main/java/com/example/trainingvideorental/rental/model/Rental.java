//package com.example.trainingvideorental.rental.model;
//
//import com.example.trainingvideorental.Movies.model.Movie;
//import com.example.trainingvideorental.Customer.model.Customer;
//
//
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "rental")
//public class Rental {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "rental_id")
//    private Long rentalId;
//
//    @OneToOne
//    @JoinColumn(name = "fk_customer")
//    private Customer customer;
//
//    @OneToOne
//    @JoinColumn(name = "fk_movie")
//    private Movie movie;
//
//    @Column(name = "rental_expiry")
//    private LocalDate rentalExpiry;
//
//    @Column(name = "total_cost")
//    private Double total_cost;
//
//    @Column(name = "is_returned")
//    private Boolean isReturned;
//
//
//
//
//    }
//
//
//
//
