package com.movies.info.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movies.info.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String>
{

}
