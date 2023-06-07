package com.codegym.hotelmanagement.service.impl;

import com.codegym.hotelmanagement.dto.request.BookingRequestDto;
import com.codegym.hotelmanagement.dto.request.RoomRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.entity.Booking;
import com.codegym.hotelmanagement.entity.BookingRoom;
import com.codegym.hotelmanagement.entity.Room;
import com.codegym.hotelmanagement.repository.BookingRoomRepository;
import com.codegym.hotelmanagement.service.BookingRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class BookingRoomServiceImpl implements BookingRoomService {
    @Autowired
    private BookingRoomRepository bookingRoomRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveBookingRoom(BookingRoom bookingRoom) {
        bookingRoomRepository.save(bookingRoom);
    }
}
