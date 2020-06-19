package com.movies.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.catalog.model.Catalog;
import com.movies.catalog.service.CatalogService;

@RestController
@RequestMapping(value = "/catalog")
public class CatalogController 
{
	@Autowired
	private CatalogService catalogService;
	
//---------------------------------------------------------------GET LIST OF MOVIES CATALOG, RATING BY SINGLE USER------------
	
	@RequestMapping("/users/{id}")
	public List<Catalog> getMoviesCatalogs(@PathVariable("id") String id)
	{
		return catalogService.getMoviesCatalogs(id);
	}
	
//------------------------------------------------------GET SINGLE MOVIE'S CATALOG WHICH IS RATING BY MULTIPLE USERS----------
	
	@RequestMapping("/movies/{id}")
	public Catalog getMoviesCatalog(@PathVariable("id") String id)
	{	
		return catalogService.getMoviesCatalog(id);		
	}
}
	 
