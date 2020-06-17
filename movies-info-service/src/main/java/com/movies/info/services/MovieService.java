package com.movies.info.services;

import java.util.List;

import com.movies.info.model.Movie;

public interface MovieService
{
	public Movie saveMovie(Movie movie);

	public List<Movie> getMovies();

	public Movie getMovie(String id);

	public Movie updateMovie(String id, Movie movie);

	public void deleteMovie(String id);
}
