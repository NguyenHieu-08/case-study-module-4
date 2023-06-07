package com.codegym.hotelmanagement.service.impl;

import com.codegym.hotelmanagement.dto.request.SearchCustomerRequestDto;
import com.codegym.hotelmanagement.dto.response.CustomerResponseDto;
import com.codegym.hotelmanagement.entity.Customer;
import com.codegym.hotelmanagement.dto.request.CustomerRequestDto;
import com.codegym.hotelmanagement.mapper.CustomerMapper;
import com.codegym.hotelmanagement.repository.BookingRepository;
import com.codegym.hotelmanagement.repository.CustomerRepository;
import com.codegym.hotelmanagement.service.BookingService;
import com.codegym.hotelmanagement.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private BookingService bookingService;

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        customerResponseDtos = customerMapper.entitiesToResponseDtos(customers);
        return customerResponseDtos;
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        Customer customer = customerRepository.findById(id).get();
        customerResponseDto = customerMapper.entityToResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto searchCustomer(SearchCustomerRequestDto searchCustomerRequestDto) {
        Customer customer = customerRepository.searchCustomer(searchCustomerRequestDto.getFullName(),
                                                                searchCustomerRequestDto.getPhoneNumber(),
                                                                searchCustomerRequestDto.getCitizenIdentityCard());
        CustomerResponseDto customerResponseDto = customerMapper.entityToResponseDto(customer);
        return customerResponseDto;
    }


    @Override
    public CustomerResponseDto addNewCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer  = customerMapper.requestDtoToEntity(customerRequestDto);
        customerRepository.save(customer);
        Long idCustomer = customerRepository.getNewId();
        Long idBooking = bookingRepository.getNewId();
        bookingService.insertCustomerId(idCustomer,idBooking);
        CustomerResponseDto customerResponseDto = customerMapper.entityToResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto editCustomer(Long id, CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepository.findById(id).get();
        BeanUtils.copyProperties(customerRequestDto, customer);
        customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = customerMapper.entityToResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {}

    @Override
    public void deleteById(Long id) {}
}
