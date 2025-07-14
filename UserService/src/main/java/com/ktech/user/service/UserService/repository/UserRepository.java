package com.ktech.user.service.UserService.repository;

import com.ktech.user.service.UserService.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
