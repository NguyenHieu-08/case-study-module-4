package com.codegym.hotelmanagement.service;

import com.codegym.hotelmanagement.dto.request.BookingDetailRequestDto;
import com.codegym.hotelmanagement.dto.request.BookingRequestDto;
import com.codegym.hotelmanagement.dto.response.BookingResponseDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.entity.BookingRoom;

import java.util.List;

public interface BookingService {
    List<BookingResponseDto> getAllBookings();

    BookingResponseDto getBookingById(Long id);

    BookingResponseDto getBookingByPhone(String phone);

    void saveBooking(BookingRequestDto bookingRequestDto);

    void deleteBookingById(Long id);

    public List<RoomResponseDto> roomsIsAvailable(BookingRequestDto bookingRequestDto);

    void addNewBooking(BookingDetailRequestDto bookingDetailRequestDto);

    void insertCustomerId(Long idCustomer, Long idBooking);
}
