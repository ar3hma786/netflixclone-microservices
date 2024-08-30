package com.netflix.seasonservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netflix.seasonservice.entities.Seasons;



public interface SeasonsRepository extends JpaRepository<Seasons, Long> {

}
