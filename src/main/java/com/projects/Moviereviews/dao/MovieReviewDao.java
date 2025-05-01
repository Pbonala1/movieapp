package com.projects.Moviereviews.dao;

import com.projects.Moviereviews.model.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieReviewDao extends JpaRepository<MovieReview,Integer> {
    List<MovieReview> findByMovie_MovieName(String movieName);

    List<MovieReview> findByusername(String username);

    void deleteByusername(String username);

    void deleteByMovie_MovieName(String movieName);

    List<MovieReview> findByusernameAndMovie_MovieName(String username, String movieName);


    boolean existsByusernameAndMovie_MovieName(String username, String moviename);
}
