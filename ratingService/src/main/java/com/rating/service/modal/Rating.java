package com.rating.service.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="ratings")
public class Rating {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private Integer rating;
	
	private String feedBack;
}
