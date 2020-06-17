package com.movies.rating.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movies.rating.model.UserRating;

@Repository
public interface UserRatingRepository extends CrudRepository<UserRating, String>
{
	public List<UserRating> findByUserIdAndIsDeleted(String userId, Boolean isDeleted);

	public List<UserRating> findByMovieIdAndIsDeletedFalse(String id);
}
