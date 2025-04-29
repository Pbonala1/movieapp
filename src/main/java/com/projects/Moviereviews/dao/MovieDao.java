package com.projects.Moviereviews.dao;

import com.projects.Moviereviews.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;


public interface MovieDao extends JpaRepository<Movie,Integer> {
     List<Movie> findAllByMovieName(String movieName);

     List<Movie> findAllByMovieNameAndReleaseYear(String movieName, int releaseYear);

     boolean existsByMovieName(String movieName);


}
