package com.codegym.hotelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bookingroom")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_booking", referencedColumnName = "id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    private Room room;

    public BookingRoom(Booking booking, Room room) {
        this.booking = booking;
        this.room = room;
    }
}
