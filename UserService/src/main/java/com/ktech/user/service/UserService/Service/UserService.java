package com.ktech.user.service.UserService.Service;

import com.ktech.user.service.UserService.entites.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService
{
    List<User>getAll();

    User saveUser(User user);

    User getById(String userId);

    User updateById(User user , String  userId);

    void delete(String userId);
}
