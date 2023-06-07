package com.codegym.hotelmanagement.service;

import com.codegym.hotelmanagement.dto.response.UserResponseDto;
import com.codegym.hotelmanagement.entity.User;

import java.util.Optional;

public interface UserService extends GeneralService<User>{
//    Optional<User> findByUser(String username);
//    void saveUser(User user);
    Optional<User> checkValidUser(User user);
    UserResponseDto findByUser(String username);
    void saveUser(User user);
}
