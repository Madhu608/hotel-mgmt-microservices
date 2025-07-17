package com.hotel.service.modal;

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
@Table(name = "hotel_staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String staffId;

    private String name;
    private String role;     // e.g., Manager, Chef, Receptionist
    private String phone;
    private String email;
    private String hotelId;  // For mapping with Hotel entity
}
