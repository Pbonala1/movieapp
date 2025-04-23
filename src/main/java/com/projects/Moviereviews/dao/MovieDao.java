package com.projects.Moviereviews.dao;

import com.projects.Moviereviews.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

public interface MovieDao extends JpaRepository<Movie,Integer> {

}
