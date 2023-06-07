package com.codegym.hotelmanagement.dto.request;

import lombok.Data;

import java.util.List;
@Data
public class BookingDetailRequestDto {
    private BookingRequestDto booking;
    private List<Long> roomId;
}
