//package com.example.trainingvideorental.rental.repository;
//
//import com.example.trainingvideorental.rental.model.Rental;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//
//public interface RentalRepository extends JpaRepository<Rental, Long> {
//    @Query("select r from Rental r where r.movie.movie_Id = :movieId")
//    List<Rental> getRentalByMovieId(Long movieId);
//
//}
