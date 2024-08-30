package com.netflix.movieservice.service;

import java.util.List;

import com.netflix.movieservice.dto.MoviesRequest;
import com.netflix.movieservice.entities.Movies;
import com.netflix.movieservice.exception.MoviesException;



public interface MoviesService {
   
	public Movies registerRequest(MoviesRequest request) throws MoviesException;
	
    public Movies findById(Long movieId) throws MoviesException;
    
    public Movies updateMovies(Movies movies, Long movieId) throws MoviesException;
    
    public void deleteById(Long movieId) throws MoviesException;
    
    public Iterable<Movies> findAll();
    
    public Movies searchByTitle(String title) throws MoviesException;
    
    public List<Movies> searchByGenre(String genre) throws MoviesException;
}
