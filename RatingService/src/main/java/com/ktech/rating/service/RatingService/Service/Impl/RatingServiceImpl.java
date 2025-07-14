package com.ktech.rating.service.RatingService.Service.Impl;

import com.ktech.rating.service.RatingService.Service.RatingService;
import com.ktech.rating.service.RatingService.entites.Rating;
import com.ktech.rating.service.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public Rating create(Rating rating) {
        String randomId = UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepo.findById(ratingId).orElse(null);
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userID) {
        return ratingRepo.findByUserId(userID);
    }

    @Override
    public List<Rating>getAllHotelByUserId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
