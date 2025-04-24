package com.projects.Moviereviews.service;

import com.projects.Moviereviews.dao.MovieDao;
import com.projects.Moviereviews.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieDao movieDao;

    public ResponseEntity<Movie> createMovie(Movie movie) {

        Movie movie1 = new Movie();

        movie1.setMovieName(movie.getMovieName());
        movie1.setGenre(movie.getGenre());
        movie1.setReleaseYear(movie.getReleaseYear());

        movieDao.save(movie1);

        return new ResponseEntity<>(movie1, HttpStatus.CREATED);

    }


    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> updateMovie(int id, Movie movie) {

        try {
            Movie existing = movieDao.findById(id).get();
            existing.setMovieName(movie.getMovieName());
            existing.setGenre(movie.getGenre());
            existing.setReleaseYear(movie.getReleaseYear());

            movieDao.save(existing);
            return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);


    }

    public ResponseEntity<?> getByMovie(String movieName) {
        List<Movie> m = movieDao.findAllByMovieName(movieName);
        if (!m.isEmpty()) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("movie not present", HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<String> deleteMovie(String movieName) {
        List<Movie> movie =movieDao.findAllByMovieName(movieName);
        movieDao.deleteAll(movie);
        return new ResponseEntity<>("movie deleted",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMovieByYear(String movieName, int year) {
        List<Movie> m=movieDao.findAllByMovieNameAndReleaseYear(movieName,year);

        if(!m.isEmpty()) {
            movieDao.deleteAll(m);
            return new ResponseEntity<>("haha movie deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("movie not found",HttpStatus.NOT_FOUND);
        }
    }
}
