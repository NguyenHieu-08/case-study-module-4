package com.codegym.hotelmanagement.dto.response;

import com.codegym.hotelmanagement.entity.Booking;
import com.codegym.hotelmanagement.entity.Room;
import lombok.Data;

@Data
public class BookingRoomResponseDto {
    private Long id;

    private Booking booking;


    private Room room;
}
