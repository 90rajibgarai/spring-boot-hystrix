package com.movies.info.dao;

import java.util.List;

import com.movies.info.model.Movie;

public interface MovieDao
{
	public Movie saveMovie(Movie movie);

	public List<Movie> getMovies();

	public Movie getMovie(String id);

	public boolean existsById(String id);
}
