package com.movies.info.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MovieSummary 
{
	private String id;
	
    private String title;
    
    private String overview;
    
    private String status;
    
    private String tagline;
    
    private Integer revenue;
    
    private String release_date;
    
    private String poster_path;
    
    private List<ProductionCompany> production_companies;
    
    private List<ProductionCompany> production_countries;
    
    private String imdb_id;
    
    private String original_language;
    
    private Float popularity;
    
    private Integer budget;
    
    private List<Genre> genres;
    
    private boolean adult;
}
