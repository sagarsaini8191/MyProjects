package com.ktech.user.service.UserService.Service.Impl;

import com.ktech.user.service.UserService.Exception.ResourceNotFoundException;
import com.ktech.user.service.UserService.Service.UserService;
import com.ktech.user.service.UserService.entites.Hotel;
import com.ktech.user.service.UserService.entites.Rating;
import com.ktech.user.service.UserService.entites.User;
import com.ktech.user.service.UserService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private  final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public User getById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found" + userId));
        Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/api/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}",ratingOfUser);
        List<Rating> ratingList = Arrays.stream(ratingOfUser).toList();
        ratingList.stream().map(rating ->
        {
            Hotel hotelRating = restTemplate.getForObject("http://HOTELSERVICE/api/hotels/" + rating.getHotelId(), Hotel.class);
            logger.info("{}",hotelRating);
            rating.setHotel(hotelRating);
            return rating;
        }).collect(Collectors.toList());


        user.setRatingList(ratingList);
        return user;
    }

    @Override
    public User updateById(User user,String userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found" + userId));
               existingUser.setName(user.getName());
               existingUser.setEmail(user.getEmail());
               existingUser.setAbout(user.getAbout());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }
}
