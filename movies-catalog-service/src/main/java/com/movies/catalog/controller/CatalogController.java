package com.movies.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.catalog.model.Catalog;
import com.movies.catalog.model.Movie;
import com.movies.catalog.model.UserRating;
import com.movies.catalog.proxy.MoviesInfoProxy;
import com.movies.catalog.proxy.MoviesRatingProxy;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController 
{
	@Autowired
	private MoviesRatingProxy moviesRatingProxy;
	
	@Autowired
	private MoviesInfoProxy moviesInfoProxy;
	
//---------------------------------------------------------------GET LIST OF MOVIES CATALOG, RATING BY SINGLE USER------------
	
	@RequestMapping("/users/{id}")
	public List<Catalog> getMoviesCatalogs(@PathVariable("id") String id)
	{
		List<Catalog> catalogs = new ArrayList<>();
		
		List<UserRating> userRatings = moviesRatingProxy.getUserRatings(id);
		
		for (UserRating userRating : userRatings) 
		{
			Movie movie = moviesInfoProxy.getMovie(userRating.getMovieId());
			
			Catalog catalog = new Catalog();
			
			catalog.setName(movie.getName());
			catalog.setDescription(movie.getDescription());
			catalog.setRating(userRating.getRating());
			
			catalogs.add(catalog);
		}		
		return catalogs;
	}
	
//------------------------------------------------------GET SINGLE MOVIE'S CATALOG WHICH IS RATING BY MULTIPLE USERS----------
	
	@RequestMapping("/movies/{id}")
	public Catalog getMoviesCatalog(@PathVariable("id") String id)
	{		
		Catalog catalog = new Catalog();
		
		float rating = 1.0F;
		
		List<UserRating> userRatings = moviesRatingProxy.getMovieRatings(id);
		
		for (UserRating userRating : userRatings) 
		{
			rating = rating + userRating.getRating();
		}		
		
		int rate = (int) (rating/userRatings.size());
				
		Movie movie = moviesInfoProxy.getMovie(id);
		
		catalog.setName(movie.getName());
		catalog.setDescription(movie.getDescription());
		
		catalog.setRating(rate);
		
		return catalog;
	}
}
	 
