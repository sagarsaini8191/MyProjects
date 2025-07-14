package com.ktech.rating.service.RatingService.Service;

import com.ktech.rating.service.RatingService.entites.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
  //create the rating
    Rating create(Rating rating);

    //get All Rating List
     List<Rating>getAllRating();
     Rating getRatingById(String ratingId);

     //get rating by User Id

    List<Rating>getAllRatingByUserId(String userID);

    List<Rating>getAllHotelByUserId(String hotelId);
}
