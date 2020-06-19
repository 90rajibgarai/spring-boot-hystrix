package com.movies.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.catalog.model.Movie;
import com.movies.catalog.proxy.MoviesInfoProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MoviesService
{
	@Autowired
	public MoviesInfoProxy moviesInfoProxy;
	
	@HystrixCommand(fallbackMethod = "getMovieFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")	
	})
	public Movie getMovie(String moviesId)
	{
		return moviesInfoProxy.getMovie(moviesId);
	}

	public Movie getMovieFallback(String moviesId)
	{
		Movie movie = new Movie();
		
		movie.setId(moviesId);
		movie.setName("Not Found");
		movie.setDescription("This movies is Not available");
		
		return movie;
	}
}
