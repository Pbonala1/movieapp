package com.projects.Moviereviews.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class MovieReview {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String comment;
    private double rating;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public MovieReview() {
    }

    public MovieReview(String username, String comment, double rating, LocalDateTime timeStamp, Movie movie) {
        this.username = username;
        this.comment = comment;
        this.rating = rating;
        this.timeStamp = timeStamp;
        this.movie = movie;
    }

    public MovieReview(int id, String username, String comment, double rating, LocalDateTime timeStamp, Movie movie) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.rating = rating;
        this.timeStamp = timeStamp;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
