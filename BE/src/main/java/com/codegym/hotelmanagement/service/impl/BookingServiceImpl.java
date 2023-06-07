package com.codegym.hotelmanagement.service.impl;

import com.codegym.hotelmanagement.dto.request.BookingDetailRequestDto;
import com.codegym.hotelmanagement.dto.request.BookingRequestDto;
import com.codegym.hotelmanagement.dto.response.BookingResponseDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.entity.Booking;
import com.codegym.hotelmanagement.entity.BookingRoom;
import com.codegym.hotelmanagement.entity.Room;
import com.codegym.hotelmanagement.repository.BookingRepository;
import com.codegym.hotelmanagement.service.BookingRoomService;
import com.codegym.hotelmanagement.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRoomService bookingRoomService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomServiceImpl roomService;

    @Override
    public List<BookingResponseDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingResponseDto> bookingResponseDtos = bookings.stream().map(booking -> modelMapper.map(booking, BookingResponseDto.class)).collect(Collectors.toList());
        return bookingResponseDtos;
    }

    @Override
    public BookingResponseDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).get();
        BookingResponseDto bookingResponseDto = modelMapper.map(booking, BookingResponseDto.class);
        return bookingResponseDto;
    }

    @Override
    public BookingResponseDto getBookingByPhone(String phone) {
        return null;
    }

    @Override
    public void saveBooking(BookingRequestDto bookingRequestDto) {
        Booking booking = modelMapper.map(bookingRequestDto, Booking.class);
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBookingById(Long id) {

    }

    @Override
    public List<RoomResponseDto> roomsIsAvailable(BookingRequestDto bookingRequestDto) {
        List<RoomResponseDto> roomResponseDtoList = roomService.findAll();
        LocalDate dateStart = bookingRequestDto.getDateStart();
        LocalDate dateEnd = bookingRequestDto.getDateEnd();
        while (!dateStart.isAfter(dateEnd)) {
            List<Long> isNotAvailableIdRoomList = bookingRepository.isNotAvailableIdRooms(dateStart);
            Set<Long> isNotAvailableIdRoomSet = new HashSet<>(isNotAvailableIdRoomList);
            for (int i = 0; i < roomResponseDtoList.size(); i++) {
                for (Long id : isNotAvailableIdRoomSet) {
                    if (Objects.equals(roomResponseDtoList.get(i).getId(), id)) {
                        roomResponseDtoList.remove(i);
                    }
                }
            }
            dateStart = dateStart.plusDays(1);
        }
        return roomResponseDtoList;
    }

    @Override
    public void addNewBooking(BookingDetailRequestDto bookingDetailRequestDto) {
        BookingRequestDto bookingRequestDto = bookingDetailRequestDto.getBooking();
        List<Long> idRoomList = bookingDetailRequestDto.getRoomId();
        saveBooking(bookingRequestDto);
        Long idBooking = bookingRepository.getNewId();
        Booking booking = bookingRepository.findById(idBooking).get();
        for (int i = 0; i < idRoomList.size(); i++) {
            RoomResponseDto roomResponseDto = roomService.findById(idRoomList.get(i));
            Room room = modelMapper.map(roomResponseDto, Room.class);
            BookingRoom bookingRoom = new BookingRoom(booking, room);
            bookingRoomService.saveBookingRoom(bookingRoom);
        }
    }

    @Override
    public void insertCustomerId(Long idCustomer, Long idBooking) {
        bookingRepository.insertCustomerId(idCustomer, idBooking);
    }
}
