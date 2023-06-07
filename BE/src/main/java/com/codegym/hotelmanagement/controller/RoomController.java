package com.codegym.hotelmanagement.controller;


import com.codegym.hotelmanagement.dto.request.RoomRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllRoom(){
        List<RoomResponseDto> rooms = roomService.findAll();
        return ResponseEntity.ok().body(rooms);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoomById(@PathVariable("id") Long id){
        roomService.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable("id") Long id){
        RoomResponseDto room = roomService.findById(id);
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody RoomRequestDto roomRequestDto){
        roomService.saveRoom(roomRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateRoom(@RequestBody RoomRequestDto roomRequestDto){
        roomService.saveRoom(roomRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
