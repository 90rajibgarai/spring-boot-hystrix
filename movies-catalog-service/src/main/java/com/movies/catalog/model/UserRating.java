package com.movies.catalog.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserRating
{
	private String ratingId;
	
	private String userId;
	
	private String movieId;	
	
    private Integer rating;
    
    private LocalDate dateAdded;
    
    private boolean isDeleted;    
}
