package com.codegym.hotelmanagement.service.impl;

import com.codegym.hotelmanagement.dto.response.UserResponseDto;
import com.codegym.hotelmanagement.entity.User;
import com.codegym.hotelmanagement.repository.UserRepository;
import com.codegym.hotelmanagement.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {

    }
    @Override
    public Optional<User> checkValidUser(User user) {
        return userRepository.checkUserIsValid(user);
    }

    @Override
    public UserResponseDto findByUser(String username) {
        User newUser = userRepository.checkUser(username);
        UserResponseDto userRepDto = new UserResponseDto();
        BeanUtils.copyProperties(newUser, userRepDto);
        return userRepDto;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {

    }
}
