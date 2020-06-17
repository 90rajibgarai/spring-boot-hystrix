package com.movies.catalog.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movies.catalog.model.Movie;

@RibbonClient(name="movies-info-service")
@FeignClient(name="movies-info-service")
public interface MoviesInfoProxy 
{
	@GetMapping("/movies/{id}")
	public Movie getMovie(@PathVariable("id") String id);
}
