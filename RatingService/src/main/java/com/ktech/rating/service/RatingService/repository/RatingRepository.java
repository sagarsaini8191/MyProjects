package com.ktech.rating.service.RatingService.repository;

import com.ktech.rating.service.RatingService.entites.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String>
{
   List<Rating>findByUserId(String userId);
   
   List<Rating>findByHotelId(String hotelId);

}
