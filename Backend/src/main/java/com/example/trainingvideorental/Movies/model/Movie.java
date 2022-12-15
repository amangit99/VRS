package com.example.trainingvideorental.Movies.model;

import com.example.trainingvideorental.rental.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "movie")

public class Movie extends Auditable<String> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_Id;

    @Column(name = "language")
    private String language;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private double price;

    @Column(name = "year")
    private LocalDate year;

    private int totalQuantity;
    private int remainingQuantity;

    public Movie() {

    }

    public Movie(String language, String title, String genre, double price,
                 LocalDate year, Integer totalQuantity, Integer remainingQuantity
                 ) {
        this.language = language;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.year = year;
        this.totalQuantity = totalQuantity;
        this.remainingQuantity = remainingQuantity;


    }


    public Long getVideo_Id() {
        return movie_Id;
    }


    public Long getMovie_Id() {
        return movie_Id;
    }

    public void setMovie_Id(Long movie_Id) {
        this.movie_Id = movie_Id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price;    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public int getTotalQuantity() { return totalQuantity; }

    public void setTotalQuantity(int totalQuantity) { this.totalQuantity = Integer.valueOf(totalQuantity);}

    public int getRemainingQuantity() { return remainingQuantity; }

    public void setRemainingQuantity(int remainingQuantity) {this.remainingQuantity = Integer.valueOf(remainingQuantity);
    }
}
