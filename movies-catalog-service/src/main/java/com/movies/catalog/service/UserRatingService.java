package com.movies.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.catalog.model.UserRating;
import com.movies.catalog.proxy.MoviesRatingProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserRatingService 
{
	@Autowired
	private MoviesRatingProxy moviesRatingProxy;
	
	@HystrixCommand(fallbackMethod = "getUserRatingsFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")	
	})
	public List<UserRating> getUserRatings(String userId)
	{
		return moviesRatingProxy.getUserRatings(userId);
	}
	
	public List<UserRating> getUserRatingsFallback(String userId)
	{
		List<UserRating> userRatings = new ArrayList<>();				
		return userRatings;
	}
	
	@HystrixCommand(fallbackMethod = "getMovieRatingsFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")	
	})
	public List<UserRating> getMovieRatings(String moviesId)
	{
		return moviesRatingProxy.getMovieRatings(moviesId);
	}
	
	public List<UserRating> getMovieRatingsFallback(String moviesId)
	{
		List<UserRating> userRatings = new ArrayList<>();		
		return userRatings;
	}
}
