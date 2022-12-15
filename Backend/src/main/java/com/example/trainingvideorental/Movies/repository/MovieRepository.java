package com.example.trainingvideorental.Movies.repository;

import com.example.trainingvideorental.Movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long> {



}
