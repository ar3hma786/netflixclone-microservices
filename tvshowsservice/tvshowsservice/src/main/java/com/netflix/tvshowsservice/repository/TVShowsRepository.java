package com.netflix.tvshowsservice.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.netflix.tvshowsservice.entities.TVShows;

public interface TVShowsRepository extends JpaRepository<TVShows, Long> {
    
    @Query("SELECT t FROM TVShows t WHERE t.tvshowName = :tvshowName")
    Optional<TVShows> findByTvshowName(@Param("tvshowName") String tvshowName);

}
