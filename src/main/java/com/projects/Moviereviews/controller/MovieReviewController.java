package com.projects.Moviereviews.controller;

import com.projects.Moviereviews.model.MovieReview;
import com.projects.Moviereviews.service.MovieReviewService;
import com.projects.Moviereviews.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
public class MovieReviewController {
    @Autowired
    private MovieReviewService movieReviewService;

    @PostMapping("create/{movieName}")
    ResponseEntity<?> createReview(@PathVariable String movieName, @RequestBody MovieReview movieReview){
        return movieReviewService.createReview(movieName,movieReview);
    }

    @GetMapping("getall")
    ResponseEntity<List<MovieReview>> getAllReviews(){
        return movieReviewService.getAllReviews();
    }
    @GetMapping("getByMovie/{movieName}")
    ResponseEntity<List<MovieReview>> getReviewsByMovie(@PathVariable String movieName){
        return movieReviewService.getReviewsByMovie(movieName);
    }
    @GetMapping("getByUser/{username}")
    ResponseEntity<List<MovieReview>> getReviewsByUser(@PathVariable String username){
        return  movieReviewService.getReviewsByUser(username);
    }
    @DeleteMapping("deleteall")
    ResponseEntity<String> deleteAll(){
        return movieReviewService.deleteAll();
    }
    @Transactional
    @DeleteMapping("deleteUser/{username}")
    ResponseEntity<String> deleteByUser(@PathVariable String username){
        return movieReviewService.deleteByUser(username);
    }
    @Transactional
    @DeleteMapping("deleteMovie/{moviename}")
    ResponseEntity<String> deleteByMovieName(@PathVariable String moviename){
        return movieReviewService.deleteByMovieName(moviename);
    }

    @PutMapping("update/{moviename}/{username}")
    ResponseEntity<?> updateReview(@PathVariable String moviename,@PathVariable String username,@RequestBody MovieReview movieReview){
        return movieReviewService.updateReview(moviename,username,movieReview);
    }
}
