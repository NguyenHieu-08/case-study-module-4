package com.codegym.hotelmanagement.mapper;


import com.codegym.hotelmanagement.dto.request.RoomRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.entity.Room;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper {

    public List<RoomResponseDto> entitiesToDtos(List<Room> rooms) {
        List<RoomResponseDto> roomResponseDtos = new ArrayList<>();
        rooms.forEach(element -> roomResponseDtos.add(entityToDto(element)));
        return roomResponseDtos;
    }

    public RoomResponseDto entityToDto(Room room){
        RoomResponseDto roomResponseDto = new RoomResponseDto();
        BeanUtils.copyProperties(room, roomResponseDto);
        return roomResponseDto;
    }

    public Room dtoToEntity(RoomRequestDto roomRequestDto) {
        Room room = new Room();
        BeanUtils.copyProperties(roomRequestDto, room);
        return room;
    }
}
