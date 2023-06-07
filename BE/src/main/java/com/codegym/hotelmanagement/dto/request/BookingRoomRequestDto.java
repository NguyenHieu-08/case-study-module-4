package com.codegym.hotelmanagement.dto.request;

import com.codegym.hotelmanagement.entity.Booking;
import com.codegym.hotelmanagement.entity.Room;
import lombok.Data;
@Data
public class BookingRoomRequestDto {
    private Long id;

    private Booking booking;


    private Room room;
}
