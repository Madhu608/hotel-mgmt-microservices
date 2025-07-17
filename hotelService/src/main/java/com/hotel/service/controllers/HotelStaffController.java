package com.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.modal.HotelStaff;
import com.hotel.services.HotelStaffService;

@RestController
@RequestMapping("/api/hotel-staff")
public class HotelStaffController {

    @Autowired
    private HotelStaffService hotelStaffService;

    @PostMapping
    public ResponseEntity<HotelStaff> addStaff(@RequestBody HotelStaff staff) {
        return ResponseEntity.ok(hotelStaffService.addStaff(staff));
    }

    @GetMapping
    public ResponseEntity<List<HotelStaff>> getAllStaff() {
        return ResponseEntity.ok(hotelStaffService.getAllStaff());
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<HotelStaff>> getStaffByHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelStaffService.getStaffByHotelId(hotelId));
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable String staffId) {
        hotelStaffService.deleteStaff(staffId);
        return ResponseEntity.ok("Staff deleted successfully");
    }
}
