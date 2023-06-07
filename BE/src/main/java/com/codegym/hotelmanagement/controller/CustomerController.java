package com.codegym.hotelmanagement.controller;

import com.codegym.hotelmanagement.dto.request.CustomerRequestDto;
import com.codegym.hotelmanagement.dto.request.SearchCustomerRequestDto;
import com.codegym.hotelmanagement.dto.response.CustomerResponseDto;
import com.codegym.hotelmanagement.service.BookingService;
import com.codegym.hotelmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingService bookingService;

    //Get
    @GetMapping("/list")
    public ResponseEntity<?> listCustomer() {
        List<CustomerResponseDto> customerResponse = customerService.getAllCustomers();
        return new ResponseEntity(customerResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
        CustomerResponseDto customerResponseDto = customerService.getCustomerById(id);
        if (customerResponseDto == null) {
            return new ResponseEntity<CustomerResponseDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
    }

    //Post
    @PostMapping("/add")
    public ResponseEntity<?> addNewCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        CustomerResponseDto customerResponseDto = customerService.addNewCustomer(customerRequestDto);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchCustomer(@RequestBody SearchCustomerRequestDto searchCustomerRequestDto) {
        CustomerResponseDto customerResponseDto = customerService.searchCustomer(searchCustomerRequestDto);
        if (customerResponseDto == null) {
            return new ResponseEntity<CustomerResponseDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
    }

    //Put
    @PutMapping("edit/{id}")
    public ResponseEntity<?> editCustomer(@PathVariable("id") Long id, @RequestBody CustomerRequestDto customerRequestDto) {
        CustomerResponseDto customerResponseDtos = customerService.editCustomer(id, customerRequestDto);
        return new ResponseEntity<>(customerResponseDtos, HttpStatus.CREATED);
    }

}
