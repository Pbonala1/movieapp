package com.projects.Moviereviews.service;

import com.projects.Moviereviews.dao.MovieDao;
import com.projects.Moviereviews.dao.MovieReviewDao;
import com.projects.Moviereviews.model.MovieReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieReviewService {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MovieReviewDao movieReviewDao;

    public ResponseEntity<?> createReview(String movieName, MovieReview movieReview) {
        String username=movieReview.getUsername();

        if (movieReviewDao.existsByusernameAndMovie_MovieName(username, movieName)){
            updateReview(movieName,username,movieReview);
            return new ResponseEntity<>("updated",HttpStatus.OK);
        }
        try {
            if (movieDao.existsByMovieName(movieName)) {
                MovieReview movieReview1 = new MovieReview();

                movieReview1.setUsername(movieReview.getUsername());
                movieReview1.setComment(movieReview.getComment());
                movieReview1.setRating(movieReview.getRating());
                movieReview1.setTimeStamp(LocalDateTime.now());
                movieReview1.setMovie(movieDao.findAllByMovieName(movieName).get(0));

                movieReviewDao.save(movieReview1);
                return new ResponseEntity<>(movieReview1, HttpStatus.CREATED);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("movie not present", HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<List<MovieReview>> getAllReviews() {
        return new ResponseEntity<>(movieReviewDao.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<List<MovieReview>> getReviewsByMovie(String movieName) {
        return new ResponseEntity<>(movieReviewDao.findByMovie_MovieName(movieName), HttpStatus.OK);
    }

    public ResponseEntity<List<MovieReview>> getReviewsByUser(String username) {
        return new ResponseEntity<>(movieReviewDao.findByusername(username), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAll() {
        movieReviewDao.deleteAll();
        return new ResponseEntity<>("deleted all reviews", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteByUser(String username) {
        movieReviewDao.deleteByusername(username);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteByMovieName(String movieName) {
        movieReviewDao.deleteByMovie_MovieName(movieName);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    public ResponseEntity<?> updateReview(String moviename, String username, MovieReview movieReview) {
        try {
            if (movieReviewDao.existsByusernameAndMovie_MovieName(username, moviename)) {
                MovieReview m1=movieReviewDao.findByusernameAndMovie_MovieName(username, moviename).get(0);
                m1.setComment(movieReview.getComment());
                m1.setRating(movieReview.getRating());
                m1.setTimeStamp(LocalDateTime.now());

                movieReviewDao.save(m1);
                return new ResponseEntity<>(m1, HttpStatus.OK);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("user or movie not found", HttpStatus.NOT_FOUND);


    }
}
