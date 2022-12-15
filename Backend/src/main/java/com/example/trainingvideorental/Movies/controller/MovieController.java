package com.example.trainingvideorental.Movies.controller;

import com.example.trainingvideorental.Movies.exception.ResourceNotFoundException;
import com.example.trainingvideorental.Movies.repository.MovieRepository;
import com.example.trainingvideorental.Movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/movies")
public class MovieController {

        @Autowired
        private MovieRepository movieRepository;

        //get all movies

        @GetMapping("/")
        public List<Movie> getAllMovies() {

                return movieRepository.findAll();
        }

        //creat videos rest Api

        @PostMapping("/")
        public Movie createMovie(@RequestBody Movie movie) {
                movie.setRemainingQuantity(movie.getTotalQuantity());
                return movieRepository.save(movie);
        }

//get videos by rest api

        @GetMapping("/{id}")
        public ResponseEntity<Movie> getMovieByID(@PathVariable Long id) {
                Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Videos nor Exist  with id : " + id));
                return ResponseEntity.ok(movie);
        }


        //Update videos rest API

        @PutMapping("/{id}")
        public ResponseEntity<Movie> updateVideo(@PathVariable Long id, @RequestBody Movie movieDetails) {
                Movie movie = movieRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Videos nor Exist  with id : " + id));

                movie.setLanguage(movieDetails.getLanguage());
                movie.setGenre(movieDetails.getGenre());
                movie.setPrice(movieDetails.getPrice());
                movie.setTitle(movieDetails.getTitle());
                movie.setYear(movieDetails.getYear());
                movie.setTotalQuantity(movieDetails.getTotalQuantity());
                movie.setRemainingQuantity(movieDetails.getTotalQuantity());
                Movie updateVideo = movieRepository.save(movie);

                return ResponseEntity.ok(updateVideo);
        }

        // delete videos rest API

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteVideo(@PathVariable Long id) {
                Movie video = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Videos nor Exist  with id : " + id));

                movieRepository.delete(video);
                Map<String, Boolean> response =  new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return ResponseEntity.ok(response);
        }

}