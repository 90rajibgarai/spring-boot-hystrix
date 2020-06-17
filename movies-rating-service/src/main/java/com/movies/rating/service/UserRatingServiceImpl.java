package com.movies.rating.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.rating.dao.UserRatingDao;
import com.movies.rating.model.UserRating;

@Service
public class UserRatingServiceImpl implements UserRatingService
{
	@Autowired
	private UserRatingDao userRatingDao;
	
	@Override
	public UserRating saveUserRating(UserRating userRating)
	{
		userRating.setDeleted(false);
		userRating.setDateAdded(LocalDate.now());
		
		return userRatingDao.saveUserRating(userRating);
	}

	@Override
	public List<UserRating> getUserRatings()
	{
		return userRatingDao.getUserRatings();
	}

	@Override
	public List<UserRating> getUserRatings(String userId)
	{
		return userRatingDao.getUserRatings(userId);
	}

	@Override
	public void deleteUserRating(String ratingId)
	{
		
	}

	@Override
	public UserRating getUserRating(String ratingId)
	{
		return userRatingDao.getUserRating(ratingId);
	}

	@Override
	public List<UserRating> getMovieRatings(String id)
	{
		return userRatingDao.getMovieRatings(id);
	}
}
