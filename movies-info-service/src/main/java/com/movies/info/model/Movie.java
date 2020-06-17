package com.movies.info.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movie")
@Data @NoArgsConstructor @AllArgsConstructor
public class Movie
{
	@Id
	private String id;
	
    private String name;
    
    private String description;
    
    public boolean isDeleted;
    
    private LocalDate dateAdded;
    
    private LocalDate dateModified;
}
