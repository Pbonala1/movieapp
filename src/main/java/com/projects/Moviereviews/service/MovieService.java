package com.projects.Moviereviews.service;

import com.projects.Moviereviews.dao.MovieDao;
import com.projects.Moviereviews.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieDao movieDao;

    public ResponseEntity<Movie> createMovie(Movie movie) {

        Movie movie1=new Movie();

                movie1.setMovieName(movie.getMovieName());
                movie1.setGenre(movie.getGenre());
                movie1.setReleaseYear(movie.getReleaseYear());

                movieDao.save(movie1);

                return new ResponseEntity<>(movie1, HttpStatus.CREATED);

    }


    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> updateMovie(int id, Movie movie) {

        try {
            Movie existing = movieDao.findById(id).get();
            existing.setMovieName(movie.getMovieName());
            existing.setGenre(movie.getGenre());
            existing.setReleaseYear(movie.getReleaseYear());

            movieDao.save(existing);
            return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);


    }
}
