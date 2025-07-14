package com.ktech.hotel.service.HotelService.Service;

import com.ktech.hotel.service.HotelService.entites.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

   Hotel create(Hotel hotel);

   List<Hotel>getAllHotel();

   Hotel getById(String hotelId);
}
