package com.movies.info.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movies.info.model.MovieSummary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieSummaryServiceImpl implements MovieSummaryService
{
	@Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
	    
	@Override
	public MovieSummary getMovieSummary(String id)
	{
		MovieSummary movieSummary = new MovieSummary();
		
		try
		{
			movieSummary = restTemplate.getForObject(("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey).trim(), MovieSummary.class);
		}
		catch(Exception e)
		{
			log.error("Error in call movieSummary 3rd party API calling : {}, {}", e.getCause(), e.getMessage());
		}
		
		return movieSummary;
	}
	
}
