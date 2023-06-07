package com.codegym.hotelmanagement.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDto {
    private Long id;

    private Long idRoom;

    private Long idCustomer;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private Long amount;

    private Boolean isFinish;

}
