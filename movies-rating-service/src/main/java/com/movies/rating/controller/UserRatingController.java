package com.movies.rating.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movies.rating.model.UserRating;
import com.movies.rating.service.UserRatingService;

@RestController
@RequestMapping(value = "/user-rating")
public class UserRatingController 
{
	@Autowired
	private UserRatingService userRatingService;
	
//--------------------------------------------------SAVE USER RATING-----------------------------------------------------------	
	@PostMapping()
	public ResponseEntity<Object> saveUserRating(@RequestBody UserRating userRating)
	{
		UserRating saveUserRating = userRatingService.saveUserRating(userRating);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUserRating.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
//--------------------------------------------------GET RATING LIST--------------------------------------------------------
	@GetMapping()
	public List<UserRating> getUserRatings() 
	{		
		return userRatingService.getUserRatings();
	}
	
//-------------------------------------------------GET RATING INFO BY ID--------------------------------------------------------

	@GetMapping("/{rating-id}")
	public UserRating getUserRating(@PathVariable("rating-id") String ratingId) 
	{
		return userRatingService.getUserRating(ratingId);
	}
	
//-------------------------------------------------GET RATING BY USER ID--------------------------------------------------------

	@GetMapping("/users/{id}")
	public List<UserRating> getUserRatings(@PathVariable("id") String id) 
	{
		return userRatingService.getUserRatings(id);
	}
	
//-------------------------------------------------GET RATING BY MOVIES ID--------------------------------------------------------

	@GetMapping("/movies/{id}")
	public List<UserRating> getMovieRatings(@PathVariable("id") String id) 
	{
		return userRatingService.getMovieRatings(id);
	}
	
//-------------------------------------------------DELETE RATING BY ID--------------------------------------------------------

	@DeleteMapping("/{rating-id}")
	public ResponseEntity<Object> deleteUserRating(@PathVariable("rating-id") String ratingId) 
	{
		 userRatingService.deleteUserRating(ratingId);		 
		 return ResponseEntity.ok().build();
	}
	
//---------------------------------------------------------------END------------------------------------------------------
	
}
