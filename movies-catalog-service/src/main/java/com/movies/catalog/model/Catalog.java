package com.movies.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Catalog
{
	 private String name;
	 
	 private String description;
	    
	 private int rating;
}
