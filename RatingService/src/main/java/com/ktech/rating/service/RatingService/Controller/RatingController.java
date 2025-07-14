package com.ktech.rating.service.RatingService.Controller;

import com.ktech.rating.service.RatingService.Service.RatingService;
import com.ktech.rating.service.RatingService.entites.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController
{
    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {
        return new ResponseEntity<>(ratingService.getAllRating(), HttpStatus.OK);
    }
   @GetMapping("/{ratingId}")
    public ResponseEntity<Rating>getById(@PathVariable String ratingId)
    {
        return new ResponseEntity<>(ratingService.getRatingById(ratingId),HttpStatus.OK);
    }
   @PostMapping
    public ResponseEntity<Rating>create(@RequestBody Rating rating)
    {
        return new ResponseEntity<>(ratingService.create(rating),HttpStatus.CREATED);
    }
   @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getRatingByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getAllRatingByUserId(userId));
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getAllHotelByUserId(hotelId));
    }}