package com.movies.info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductionCompany 
{
	private Integer id;
	
	private String logo_path;
	
	private String name;
	
	private String origin_country;
}
