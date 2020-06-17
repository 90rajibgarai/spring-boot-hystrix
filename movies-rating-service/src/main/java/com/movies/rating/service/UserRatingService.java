package com.movies.rating.service;

import java.util.List;

import com.movies.rating.model.UserRating;

public interface UserRatingService
{
	public UserRating saveUserRating(UserRating userRating);

	public List<UserRating> getUserRatings();

	public List<UserRating> getUserRatings(String userId);

	public void deleteUserRating(String ratingId);

	public UserRating getUserRating(String ratingId);

	public List<UserRating> getMovieRatings(String id);

}
