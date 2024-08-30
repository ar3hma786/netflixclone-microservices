package com.netflix.episodeservice.service;

import java.util.List;

import com.netflix.episodeservice.dto.EpisodesRequest;
import com.netflix.episodeservice.entities.Episodes;
import com.netflix.episodeservice.exception.EpisodesException;



public interface EpisodesService {
   
	public Episodes addEpisode(EpisodesRequest request) throws EpisodesException;
	
	public Episodes findEpisodeById(Long episodeId) throws EpisodesException;
	
	public Episodes updateEpisode(Long episodeId, Episodes episodes) throws EpisodesException;
	
	public Episodes deleteEpisode(Long episodeId) throws EpisodesException;	
	
//	public List<Episodes> getEpisodesBySeasonId(Long seasonId) throws EpisodesException;
//
//	List<Episodes> getEpisodesByTvShowId(Long tvShowId) throws EpisodesException;
	
}
