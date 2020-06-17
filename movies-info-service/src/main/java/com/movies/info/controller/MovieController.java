package com.movies.info.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movies.info.model.Movie;
import com.movies.info.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController
{
	@Autowired
	private MovieService movieService;
	
//--------------------------------------------------SAVE MOVIE-----------------------------------------------------------	
	@PostMapping()
	public ResponseEntity<Object> saveMovie(@RequestBody Movie movie)
	{
		Movie saveMovie = movieService.saveMovie(movie);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveMovie.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
//--------------------------------------------------GET MOVIES LIST--------------------------------------------------------
	@GetMapping()
	public List<Movie> getMovies() 
	{		
		return movieService.getMovies();
	}
	
//-------------------------------------------------GET MOVIE BY ID--------------------------------------------------------

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") String id) 
	{
		return movieService.getMovie(id);
	}
	
//--------------------------------------------------UPDATE MOVIE BY ID---------------------------------------------------

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMovie(@PathVariable("id") String id, @RequestBody Movie movie)
	{
		Movie updatedMovie = movieService.updateMovie(id, movie);
		
		if(!ObjectUtils.isEmpty(updatedMovie))
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}	
	
//-------------------------------------------------DELETE MOVIE BY ID----------------------------------------------------

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMovie(@PathVariable("id") String id) 
	{
		movieService.deleteMovie(id);
		return ResponseEntity.ok().build();
	}
	
//-------------------------------------------------END-------------------------------------------------------------------
}
