
package com.codegym.hotelmanagement.controller;

import com.codegym.hotelmanagement.dto.request.BookingDetailRequestDto;
import com.codegym.hotelmanagement.dto.request.BookingRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.entity.Booking;
import com.codegym.hotelmanagement.service.BookingRoomService;
import com.codegym.hotelmanagement.service.impl.BookingServiceImpl;
import com.codegym.hotelmanagement.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/available_rooms")
    public ResponseEntity<?> showAvailableRooms(@RequestBody BookingRequestDto bookingRequestDto) {
        List<RoomResponseDto> roomResponseDtoList = bookingService.roomsIsAvailable(bookingRequestDto);
        return new ResponseEntity<>(roomResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewBooking(@RequestBody BookingDetailRequestDto bookingDetailRequestDto) {
        bookingService.addNewBooking(bookingDetailRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
