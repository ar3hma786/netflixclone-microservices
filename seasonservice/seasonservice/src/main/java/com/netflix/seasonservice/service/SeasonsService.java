package com.netflix.seasonservice.service;

import com.netflix.seasonservice.dto.SeasonsRequest;
import com.netflix.seasonservice.entities.Seasons;
import com.netflix.seasonservice.exception.SeasonsException;

public interface SeasonsService {
	
	public Seasons registerSeason(SeasonsRequest request) throws SeasonsException;
    
    public Seasons updateSeason(Seasons seasons, Long seasonsId) throws SeasonsException;
    
    public Seasons findSeasonById(Long seasonId) throws SeasonsException;
    
    public Seasons deleteSeasonById(Long seasonId) throws SeasonsException;
    
    public Iterable<Seasons> findAllSeasons();
}
