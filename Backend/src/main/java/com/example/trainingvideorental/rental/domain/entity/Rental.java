package com.example.trainingvideorental.rental.domain.entity;

import com.example.trainingvideorental.Customer.model.Customer;
import com.example.trainingvideorental.Movies.model.Movie;
//import com.example.trainingvideorental.rental.Auditable;

import com.example.trainingvideorental.rental.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rental")
public class Rental extends Auditable<String>

{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id")
    private Long rentalId;
    @OneToOne
    @JoinColumn(name = "fk_customer")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "fk_movie")
    private Movie movie;

    @Column(name = "rental_expiry")
    private LocalDate rentalExpiry;
    @Column(name="total_cost")
    private Double totalCost;
    @Column(name = "is_returned")
    private Boolean isReturned;
    @Column(name = "rent_date")
    private LocalDate rentDate;
}