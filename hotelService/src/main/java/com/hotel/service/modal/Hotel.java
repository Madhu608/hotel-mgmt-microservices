package com.hotel.service.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "hotels")
public class Hotel {

	@Id
	private String hotelId;
	
	private String name;
	
	private String location;
	
	private String about;
	
}
