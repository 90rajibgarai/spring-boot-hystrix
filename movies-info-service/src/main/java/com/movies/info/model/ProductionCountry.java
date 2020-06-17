package com.movies.info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductionCountry
{
	private String iso_3166_1;
	
	private String name;
}
