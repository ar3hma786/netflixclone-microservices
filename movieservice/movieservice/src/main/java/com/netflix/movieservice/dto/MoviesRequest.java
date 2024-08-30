package com.netflix.movieservice.dto;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesRequest {
	
    private String movieName;
    
    private String image;
    
    private Long userId;
    
    private String description; 
    
    private LocalDate releaseDate;
    
    private String genre;
    
    private int durationMinutes;
}
