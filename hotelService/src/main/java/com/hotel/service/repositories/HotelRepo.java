package com.hotel.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.modal.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
