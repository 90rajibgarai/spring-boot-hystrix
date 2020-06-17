package com.movies.rating.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user_rating")
@Data @AllArgsConstructor @NoArgsConstructor
public class UserRating
{
	@Id
	private String ratingId;
	
	private String userId;
	
	private String movieId;	
	
    private Integer rating;
    
    private LocalDate dateAdded;
    
    private boolean isDeleted;    
}
