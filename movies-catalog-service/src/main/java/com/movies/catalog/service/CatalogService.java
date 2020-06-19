package com.movies.catalog.service;

import java.util.List;

import com.movies.catalog.model.Catalog;

public interface CatalogService 
{
	public List<Catalog> getMoviesCatalogs(String userId);

	public Catalog getMoviesCatalog(String moviesId);
}
