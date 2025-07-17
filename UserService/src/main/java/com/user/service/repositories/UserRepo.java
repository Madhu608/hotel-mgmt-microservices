package com.user.service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.modal.User;

public interface UserRepo extends JpaRepository<User, String> {

	
	Optional<User> findByUserId(String userId);

}
