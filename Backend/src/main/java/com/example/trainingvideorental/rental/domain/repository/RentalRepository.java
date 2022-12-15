package com.example.trainingvideorental.rental.domain.repository;

import com.example.trainingvideorental.rental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {

    @Query("select r from Rental r where r.movie.movie_Id = :movieId")
    List<Rental> getRentalsByMovieId(Long movieId);




}
