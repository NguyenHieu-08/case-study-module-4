package com.codegym.hotelmanagement.service;

import com.codegym.hotelmanagement.dto.request.RoomRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;

public interface RoomService extends GeneralService<RoomResponseDto> {

    void saveRoom(RoomRequestDto roomRequestDto);
}

