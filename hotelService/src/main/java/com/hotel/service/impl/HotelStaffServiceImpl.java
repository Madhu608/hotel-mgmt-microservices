package com.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.modal.HotelStaff;
import com.hotel.service.repositories.HotelStaffRepo;
import com.hotel.services.HotelStaffService;

import java.util.List;

@Service
public class HotelStaffServiceImpl implements HotelStaffService {

    @Autowired
    private HotelStaffRepo hotelStaffRepo ;

    @Override
    public HotelStaff addStaff(HotelStaff staff) {
        return hotelStaffRepo.save(staff);
    }

    @Override
    public List<HotelStaff> getAllStaff() {
        return hotelStaffRepo.findAll();
    }

    @Override
    public List<HotelStaff> getStaffByHotelId(String hotelId) {
        return hotelStaffRepo.findByHotelId(hotelId);
    }

    @Override
    public void deleteStaff(String staffId) {
    	hotelStaffRepo.deleteById(staffId);
    }
}