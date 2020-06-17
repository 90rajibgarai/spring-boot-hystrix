package com.movies.rating.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.rating.exception.ResourceNotFoundException;
import com.movies.rating.model.UserRating;
import com.movies.rating.repository.UserRatingRepository;

@Service
public class UserRatingDaoImpl implements UserRatingDao
{
	@Autowired
	private UserRatingRepository userRatingRepository;
	
	@Override
	public UserRating saveUserRating(UserRating userRating)
	{
		return userRatingRepository.save(userRating);
	}

	@Override
	public List<UserRating> getUserRatings()
	{
		return (List<UserRating>) userRatingRepository.findAll();
	}

	@Override
	public List<UserRating> getUserRatings(String userId)
	{
		return userRatingRepository.findByUserIdAndIsDeleted(userId, Boolean.FALSE);
	}

	@Override
	public UserRating getUserRating(String ratingId)
	{
		return userRatingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("UserRating", "Id", ratingId));
	}

	@Override
	public List<UserRating> getMovieRatings(String id)
	{
		return userRatingRepository.findByMovieIdAndIsDeletedFalse(id);
	}

}
