package com.ktech.hotel.service.HotelService.repository;

import com.ktech.hotel.service.HotelService.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {
}
