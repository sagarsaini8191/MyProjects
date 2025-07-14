package com.ktech.hotel.service.HotelService.Service.impl;

import com.ktech.hotel.service.HotelService.Service.HotelService;
import com.ktech.hotel.service.HotelService.entites.Hotel;
import com.ktech.hotel.service.HotelService.exception.ResourceNotFoundException;
import com.ktech.hotel.service.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomUUId = UUID.randomUUID().toString();
        hotel.setHotelId(randomUUId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();

    }

    @Override
    public Hotel getById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel of this Id is not found" + hotelId));
    }
}
