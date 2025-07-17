package com.hotel.service.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.modal.HotelStaff;

import java.util.List;

public interface HotelStaffRepo extends JpaRepository<HotelStaff, String> {
	
    List<HotelStaff> findByHotelId(String hotelId);
}