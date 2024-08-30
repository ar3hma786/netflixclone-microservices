package com.netflix.episodeservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.netflix.episodeservice.dto.EpisodesRequest;
import com.netflix.episodeservice.entities.Episodes;
import com.netflix.episodeservice.exception.EpisodesException;
import com.netflix.episodeservice.service.EpisodesService;


@RestController
@RequestMapping("/api/episodes")
public class EpisodesController {

	
//    @Autowired
//    private UserService userService;
    
    @Autowired
    private EpisodesService episodesService;

   

    @PostMapping("/")
    public ResponseEntity<?> registerEpisode(@RequestBody EpisodesRequest request, @RequestHeader("Authorization") String jwt) throws EpisodesException {
        try {
//            User user = userService.findUserProfileByJwt(jwt);
//            if (user == null) {
//                return new ResponseEntity<>("User not authorized", HttpStatus.UNAUTHORIZED);
//            }
            Episodes episode = episodesService.addEpisode(request);
            return new ResponseEntity<>(episode, HttpStatus.CREATED);
        } catch (EpisodesException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error registering episode", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{episodeId}")
    public ResponseEntity<?> findEpisodeById(@PathVariable Long episodeId, @RequestHeader("Authorization") String jwt) throws EpisodesException {
        try {
//            User user = userService.findUserProfileByJwt(jwt);
//            if (user == null) {
//                return new ResponseEntity<>("User not authorized", HttpStatus.UNAUTHORIZED);
//            }
            Episodes episode = episodesService.findEpisodeById(episodeId);
            return new ResponseEntity<>(episode, HttpStatus.OK);
        } catch (EpisodesException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{episodeId}")
    public ResponseEntity<?> updateEpisode(@PathVariable Long episodeId, @RequestBody Episodes episodes, @RequestHeader("Authorization") String jwt) throws EpisodesException {
        try {
//            User user = userService.findUserProfileByJwt(jwt);
//            if (user == null) {
//                return new ResponseEntity<>("User not authorized", HttpStatus.UNAUTHORIZED);
//            }
            Episodes updatedEpisode = episodesService.updateEpisode(episodeId, episodes);
            return new ResponseEntity<>(updatedEpisode, HttpStatus.OK);
        } catch (EpisodesException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating episode", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @DeleteMapping("/{episodeId}")
//    public ResponseEntity<?> deleteEpisode(@PathVariable Long episodeId, @RequestHeader("Authorization") String jwt) throws EpisodesException {
//        try {
////            User user = userService.findUserProfileByJwt(jwt);
////            if (user == null) {
////                return new ResponseEntity<>("User not authorized", HttpStatus.UNAUTHORIZED);
////            }
//            Episodes deletedEpisode = episodesService.deleteEpisode(episodeId);
//            return new ResponseEntity<>(deletedEpisode, HttpStatus.OK);
//        } catch (EpisodesException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error deleting episode", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/season/{seasonId}")
//    public ResponseEntity<?> getEpisodesBySeasonId(@PathVariable Long seasonId, @RequestHeader("Authorization") String jwt) throws EpisodesException {
//        try {
////            User user = userService.findUserProfileByJwt(jwt);
////            if (user == null) {
////                return new ResponseEntity<>("User not authorized", HttpStatus.UNAUTHORIZED);
////            }
//            List<Episodes> episodes = episodesService.getEpisodesBySeasonId(seasonId);
//            return new ResponseEntity<>(episodes, HttpStatus.OK);
//        } catch (EpisodesException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
}
