package com.projects.Moviereviews.controller;

import com.projects.Moviereviews.model.Movie;
import com.projects.Moviereviews.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
