package com.codegym.hotelmanagement.service.impl;

import com.codegym.hotelmanagement.dto.request.RoomRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.entity.Room;
import com.codegym.hotelmanagement.mapper.RoomMapper;
import com.codegym.hotelmanagement.repository.RoomRepository;
import com.codegym.hotelmanagement.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RoomResponseDto> findAll() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomResponseDto> roomsResponseDto = roomMapper.entitiesToDtos(rooms);
        return roomsResponseDto;

    }

    @Override
    public RoomResponseDto findById(Long id) {
        Room room = roomRepository.getById(id);
        RoomResponseDto roomResponseDto = roomMapper.entityToDto(room);
        return roomResponseDto;
    }

    @Override
    public void save(RoomResponseDto roomResponseDto) {

    }

    @Override
    public void saveRoom(RoomRequestDto roomRequestDto) {
        Room room = roomMapper.dtoToEntity(roomRequestDto);
        roomRepository.save(room);
    }


    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}

