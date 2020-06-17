package com.movies.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.info.exception.ResourceNotFoundException;
import com.movies.info.model.MovieSummary;
import com.movies.info.services.MovieSummaryService;

@RestController
@RequestMapping(value = "/movies/summary")
public class MovieSummaryController 
{
	@Autowired
	private MovieSummaryService movieSummaryService;
	
//-------------------------------------------------GET MOVIE BY ID--------------------------------------------------------

	@GetMapping("/{id}")
	public MovieSummary getMovieSummary(@PathVariable("id") String id) 
	{
		MovieSummary movieSummary = movieSummaryService.getMovieSummary(id);
		
		if(ObjectUtils.isEmpty(movieSummary))
			throw new ResourceNotFoundException("MovieSummary", "id", id);
		
		return movieSummary;
	}
	
}
