package com.codegym.hotelmanagement.controller;

import com.codegym.hotelmanagement.dto.request.UserRequestDto;
import com.codegym.hotelmanagement.dto.response.UserResponseDto;
import com.codegym.hotelmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequestDto userReqDto){
        UserResponseDto userRepDto = userService.findByUser(userReqDto.getUsername());
        if (userReqDto.getPassword().equals(userRepDto.getPassword())){
            return new ResponseEntity<>(userRepDto.getUsername(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
