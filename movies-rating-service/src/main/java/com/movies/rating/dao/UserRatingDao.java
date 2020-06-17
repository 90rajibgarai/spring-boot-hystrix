package com.movies.rating.dao;

import java.util.List;

import com.movies.rating.model.UserRating;

public interface UserRatingDao
{
	public UserRating saveUserRating(UserRating userRating);

	public List<UserRating> getUserRatings();

	public List<UserRating> getUserRatings(String userId);

	public UserRating getUserRating(String ratingId);

	public List<UserRating> getMovieRatings(String id);
}
