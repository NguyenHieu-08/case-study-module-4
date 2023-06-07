package com.codegym.hotelmanagement;

import com.codegym.hotelmanagement.dto.request.BookingRequestDto;
import com.codegym.hotelmanagement.dto.response.RoomResponseDto;
import com.codegym.hotelmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class HotelManagementV2Application {
//public class HotelManagementV2Application implements CommandLineRunner {

//    @Autowired
//    BookingService bookingService;

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementV2Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String dateStartString = "2023-03-28";
//        String dateEndString = "2023-03-30";
//        LocalDate dateStart = LocalDate.parse(dateStartString, DateTimeFormatter.ISO_LOCAL_DATE);
//        LocalDate dateEnd = LocalDate.parse(dateEndString, DateTimeFormatter.ISO_LOCAL_DATE);
//        Long amount = 2L;
//        BookingRequestDto bookingRequestDto = new BookingRequestDto(dateStart,dateEnd,amount);
//        List<RoomResponseDto> roomResponseDtoList = bookingService.roomsIsAvailable(bookingRequestDto);
//        System.out.println("hello");
//        for (RoomResponseDto element : roomResponseDtoList){
//            System.out.println(element.getId());
//        }
//    }
}
