package com.movies.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.catalog.model.Catalog;
import com.movies.catalog.model.Movie;
import com.movies.catalog.model.UserRating;

@Service
public class CatalogServiceImpl implements CatalogService
{
	@Autowired
	private UserRatingService userRatingService;
	
	@Autowired
	private MoviesService moviesService;
	
	@Override
	public List<Catalog> getMoviesCatalogs(String userId)
	{	
		List<Catalog> catalogs = new ArrayList<>();
		
		List<UserRating> userRatings = userRatingService.getUserRatings(userId);
		
		for (UserRating userRating : userRatings) 
		{
			Movie movie = moviesService.getMovie(userRating.getMovieId());
			
			Catalog catalog = new Catalog();
			
			catalog.setName(movie.getName());
			catalog.setDescription(movie.getDescription());
			catalog.setRating(userRating.getRating());
			
			catalogs.add(catalog);
		}		
		return catalogs;
	}

	@Override
	public Catalog getMoviesCatalog(String moviesId)
	{
		Catalog catalog = new Catalog();
		
		float rating = 1.0F;
		int rate = 0;
		
		List<UserRating> userRatings = userRatingService.getMovieRatings(moviesId);
		
		for (UserRating userRating : userRatings) 
		{
			rating = rating + userRating.getRating();
		}		
		
		if(userRatings.size() > 0)
			rate = (int) (rating/userRatings.size());
				
		Movie movie = moviesService.getMovie(moviesId);
		
		catalog.setName(movie.getName());
		catalog.setDescription(movie.getDescription());
		
		catalog.setRating(rate);
		
		return catalog;
	}
	
	
	
	
}
