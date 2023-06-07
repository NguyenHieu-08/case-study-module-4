package com.codegym.hotelmanagement.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class BookingResponseDto {

    private Long id;


    private Long idRoom;


    private Long idCustomer;


    private LocalDate dateStart;


    private LocalDate dateEnd;

    private Long amount;

    private Boolean isFinish;
}
