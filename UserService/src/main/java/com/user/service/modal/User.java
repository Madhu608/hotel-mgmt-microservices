package com.user.service.modal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "micro_users")
public class User {

	@Id
	private String userId;
	
	private String fullName;
	
	private String password;
	
	private String email;
	
	private Long mobile;
		
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
