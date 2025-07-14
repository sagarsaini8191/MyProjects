package com.ktech.hotel.service.HotelService.Controller;

import com.ktech.hotel.service.HotelService.Service.HotelService;
import com.ktech.hotel.service.HotelService.Service.impl.HotelServiceImpl;
import com.ktech.hotel.service.HotelService.entites.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @GetMapping
    public ResponseEntity<List<Hotel>>getAllHotel()
    {
        return new ResponseEntity<>(hotelService.getAllHotel(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Hotel>create(@RequestBody Hotel hotel)
    {
        return new ResponseEntity<>(hotelService.create(hotel),HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel>getById(@PathVariable String hotelId)
    {
        return new ResponseEntity<>(hotelService.getById(hotelId),HttpStatus.OK);
    }
}
