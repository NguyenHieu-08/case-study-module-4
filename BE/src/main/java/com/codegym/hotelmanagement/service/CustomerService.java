package com.codegym.hotelmanagement.service;

import com.codegym.hotelmanagement.dto.request.SearchCustomerRequestDto;
import com.codegym.hotelmanagement.dto.response.CustomerResponseDto;
import com.codegym.hotelmanagement.entity.Customer;
import com.codegym.hotelmanagement.dto.request.CustomerRequestDto;

import java.util.List;

public interface CustomerService extends GeneralService<Customer> {
    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(Long id);

    CustomerResponseDto searchCustomer(SearchCustomerRequestDto searchCustomerRequestDto);

    CustomerResponseDto addNewCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto editCustomer(Long id, CustomerRequestDto customerRequestDto);
}
