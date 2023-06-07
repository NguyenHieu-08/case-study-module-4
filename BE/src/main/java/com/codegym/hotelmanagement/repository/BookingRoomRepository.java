package com.codegym.hotelmanagement.repository;

import com.codegym.hotelmanagement.entity.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRoomRepository extends JpaRepository<BookingRoom, Long> {

}
