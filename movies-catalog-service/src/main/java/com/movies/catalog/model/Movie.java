package com.movies.catalog.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Movie
{	
	private String id;
	
    private String name;
    
    private String description;
    
    public boolean isDeleted;
    
    private LocalDate dateAdded;
    
    private LocalDate dateModified;
}
