package com.projects.Moviereviews.controller;

import com.projects.Moviereviews.model.Movie;
import com.projects.Moviereviews.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("create")
    ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }
    @GetMapping("getall")
    ResponseEntity<List<Movie>> getAllMovies(){
        return movieService.getAllMovies();
    }
    @PutMapping("update/{id}")
    ResponseEntity<String> updateMovie(@PathVariable int id,@RequestBody Movie movie){
        return movieService.updateMovie(id,movie);
    }
    @GetMapping("getmovie/{movieName}")
    ResponseEntity<?> getByMovie(@PathVariable String movieName){
        return movieService.getByMovie(movieName);
    }
    @DeleteMapping("delete/{movieName}")
    ResponseEntity<String> deleteMovie(@PathVariable String movieName){
        return movieService.deleteMovie(movieName);
    }
    @DeleteMapping("delete1/{movieName}/{year}")
    ResponseEntity<String> deleteMovieByYear(@PathVariable String movieName,@PathVariable int year) {
        return movieService.deleteMovieByYear(movieName, year);
    }


}
