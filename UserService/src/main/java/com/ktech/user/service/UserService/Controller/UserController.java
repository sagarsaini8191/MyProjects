package com.ktech.user.service.UserService.Controller;
import com.ktech.user.service.UserService.Service.UserService;
import com.ktech.user.service.UserService.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping
    ResponseEntity<List<User>> getAllUser()
    {
       return  new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    ResponseEntity<User>getById(@PathVariable String userId)
    {
        return new ResponseEntity<>(userService.getById(userId),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User>saveUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    ResponseEntity<User>updateById( @RequestBody User user,@PathVariable String userId)
    {
        return new ResponseEntity<>(userService.updateById(user,userId),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    String deleteById(@PathVariable String userId)
    {
       userService.delete(userId);
         return "Successfully delete this User";
    }
}
