package com.movies.info.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.info.exception.ResourceNotFoundException;
import com.movies.info.model.Movie;
import com.movies.info.repository.MovieRepository;

@Service
public class MovieDaoImpl implements MovieDao
{
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie saveMovie(Movie movie)
	{
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getMovies()
	{
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovie(String id) 
	{
		return movieRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Movie", "Id", id));
	}

	@Override
	public boolean existsById(String id)
	{
		return movieRepository.existsById(id);
	}
	
}
