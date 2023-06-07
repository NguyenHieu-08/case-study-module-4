package com.codegym.hotelmanagement.dto.request;
import lombok.Data;

@Data
public class RoomRequestDto {
    private Long id;
    private Integer capacity;
    private String image_url;
    private Long roomNum;

}
