package com.netflix.tvshowsservice.service;

import java.util.List;

import com.netflix.tvshowsservice.dto.TVShowsRequest;
import com.netflix.tvshowsservice.entities.TVShows;
import com.netflix.tvshowsservice.exception.TVShowsException;


public interface TVShowsService {
  
	public TVShows registerRequest(TVShowsRequest request) throws TVShowsException;
	
	public TVShows updateTVShows(TVShows request, Long tvshowsId) throws  TVShowsException;
	
	public TVShows findById(Long tvshowId) throws TVShowsException;
	
	public TVShows deleteById(Long tvshowId) throws TVShowsException;
	
	public TVShows searchByTitle(String tvShowName) throws TVShowsException;
	
	public Iterable<TVShows> findAll();
	
	public List<TVShows> searchByGenre(String genre) throws TVShowsException;
	
}
