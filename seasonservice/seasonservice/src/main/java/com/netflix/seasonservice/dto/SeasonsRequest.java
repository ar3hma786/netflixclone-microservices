package com.netflix.seasonservice.dto;

import java.util.ArrayList;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeasonsRequest {
   
    private String seasonName;
    
    private Long tvShowId;
    
    private List<Long> episodeIds = new ArrayList<>();

//	public List<Episodes> episodes; 
}
