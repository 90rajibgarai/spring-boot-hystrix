package com.movies.info.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.movies.info.dao.MovieDao;
import com.movies.info.model.Movie;

@Service
public class MovieServiceImpl implements MovieService 
{
	@Autowired
	private MovieDao movieDao;

	@Override
	public Movie saveMovie(Movie movie)
	{
		movie.setDeleted(false);
		movie.setDateAdded(LocalDate.now());
		movie.setDateModified(LocalDate.now());
		
		return movieDao.saveMovie(movie);
	}

	@Override
	public List<Movie> getMovies()
	{
		return movieDao.getMovies();
	}

	@Override
	public Movie getMovie(String id)
	{
		return movieDao.getMovie(id);
	}

	@Override
	public Movie updateMovie(String id, Movie movie)
	{
		boolean isAvailable = movieDao.existsById(id);
		
		if(isAvailable)
		{
			movie.setId(id);
			movie.setDateModified(LocalDate.now());
			
			return movieDao.saveMovie(movie);
		}		
		return null;
	}

	@Override
	public void deleteMovie(String id)
	{
		Movie movie = movieDao.getMovie(id);
		
		if(!ObjectUtils.isEmpty(movie))
		{
			movie.setDeleted(true);
			movieDao.saveMovie(movie);
		}	
	}
}
