package com.codegym.hotelmanagement.dto.response;

import lombok.*;

@Data
public class RoomResponseDto {

    private Long id;
    private Integer capacity;
    private String image_url;
    private Long roomNum;
}
