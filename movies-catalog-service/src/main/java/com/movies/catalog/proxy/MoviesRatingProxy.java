package com.movies.catalog.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movies.catalog.model.UserRating;

@RibbonClient(name="movies-rating-service")
@FeignClient(name="movies-rating-service")
public interface MoviesRatingProxy
{
	@GetMapping("/user-rating/users/{id}")
	public List<UserRating> getUserRatings(@PathVariable("id") String id);
	
	@GetMapping("/user-rating/movies/{id}")
	public List<UserRating> getMovieRatings(@PathVariable("id") String id);
}
