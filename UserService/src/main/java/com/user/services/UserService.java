package com.user.services;

import java.util.List;

import com.user.service.modal.User;

public interface UserService {

	
	User registerNewUser(User user);

	void deleteUserById(String userId);

	User updateUser(User userDto, String userId);
		
	List<User> getAllUsers();

	User getUserById(String userId);
}
