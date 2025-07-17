package com.hotel.services;

import java.util.List;

import com.hotel.service.modal.HotelStaff;

public interface HotelStaffService {
	
    HotelStaff addStaff(HotelStaff staff);
    
    List<HotelStaff> getAllStaff();
    
    List<HotelStaff> getStaffByHotelId(String hotelId);
    
    void deleteStaff(String staffId);
}