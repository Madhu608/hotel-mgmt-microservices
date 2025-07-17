package com.hotel.services;

import java.util.List;

import com.hotel.service.modal.Hotel;

public interface HotelService {
	
	    Hotel createHotel(Hotel hotel);

	    Hotel getHotelById(String hotelId);

	    List<Hotel> getAllHotels();

	    Hotel updateHotel(String hotelId, Hotel hotel);

	    void deleteHotel(String hotelId);
}
