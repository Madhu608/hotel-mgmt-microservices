package com.user.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.external.services.RatingService;
import com.user.service.modal.Hotel;
import com.user.service.modal.Rating;
import com.user.service.modal.User;
import com.user.service.repositories.UserRepo;
import com.user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User registerNewUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		User userSave = this.userRepo.save(user);
		return userSave;
	}

	@Override
	public void deleteUserById(String userId) {
		User user = userRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		userRepo.delete(user);
	}

	@Override
	public User updateUser(User userDto, String userId) {
		User existingUser = userRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

		existingUser.setFullName(userDto.getFullName());
		existingUser.setEmail(userDto.getEmail());
		existingUser.setMobile(userDto.getMobile());
		existingUser.setAbout(userDto.getAbout());

		return userRepo.save(existingUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	// using restTemplate

//	@Override
//	public User getUserById(String userId) {
//	    // 1. Get user from DB
//	    User user = userRepo.findByUserId(userId)
//	            .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
//
//	    // 2. Call Rating Service
//	    Rating[] ratingArray = restTemplate.getForObject(
//	            "http://RATING-SERVICE/api/ratings/user/" + userId,
//	            Rating[].class
//	    );
//
//	    // 3. Convert to List and enrich each Rating with Hotel info
//	    List<Rating> ratings = Arrays.stream(ratingArray)
//	            .map(rating -> {
//	                // Call Hotel Service
//	                Hotel hotel = restTemplate.getForObject(
//	                        "http://HOTEL-SERVICE/api/hotels/" + rating.getHotelId(),
//	                        Hotel.class
//	                );
//	                rating.setHotel(hotel);
//	                return rating;
//	            })
//	            .collect(Collectors.toList());
//
//	    // 4. Set ratings with hotels into user
//	    user.setRatings(ratings);
//
//	    return user;
//	}


	// using FeignClient
	
	@Override
	public User getUserById(String userId) {
	    User user = userRepo.findByUserId(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

	    // Call Rating Service
	    List<Rating> ratings = ratingService.getRatingsByUserId(user.getUserId());

	    // For each rating, call Hotel Service and set hotel info
	    ratings.forEach(rating -> {
	        Hotel hotel = hotelService.getHotel(rating.getHotelId());
	        rating.setHotel(hotel);
	    });

	    user.setRatings(ratings);

	    return user;
	}

}
