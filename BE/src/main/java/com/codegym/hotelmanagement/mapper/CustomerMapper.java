package com.codegym.hotelmanagement.mapper;

import com.codegym.hotelmanagement.dto.request.CustomerRequestDto;
import com.codegym.hotelmanagement.dto.response.CustomerResponseDto;
import com.codegym.hotelmanagement.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public List<CustomerResponseDto> entitiesToResponseDtos(List<Customer> customers) {
        List<CustomerResponseDto> responseDtos = new ArrayList<>();
        for(Customer element : customers){
            CustomerResponseDto responseDto = entityToResponseDto(element);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    public CustomerResponseDto entityToResponseDto(Customer element) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setId(element.getId());
        dto.setFullName(element.getFullName());
        dto.setDob(element.getDob());
        dto.setEmail(element.getEmail());
        dto.setGender(element.getGender());
        dto.setPhoneNumber(element.getPhoneNumber());
        dto.setCitizenIdentityCard(element.getCitizenIdentityCard());
        dto.setSpecialRequirement(element.getSpecialRequirement());
//        dto.setChildrenAmount(element.getChildrenAmount());
//        dto.setAdultAmount(element.getAdultAmount());
//        dto.setCheckIn(element.getCheckIn());
//        dto.setCheckOut(element.getCheckOut());
        return dto;
    }

    public Customer requestDtoToEntity(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();

//        customer.setId(customerRequestDto.getId());
        customer.setFullName(customerRequestDto.getFullName());
        customer.setDob(customerRequestDto.getDob());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setGender(customerRequestDto.getGender());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customer.setCitizenIdentityCard(customerRequestDto.getCitizenIdentityCard());
        customer.setSpecialRequirement(customerRequestDto.getSpecialRequirement());
//        customer.setChildrenAmount(customerRequestDto.getChildrenAmount());
//        customer.setAdultAmount(customerRequestDto.getAdultAmount());
//        customer.setCheckIn(customerRequestDto.getCheckIn());
//        customer.setCheckOut(customerRequestDto.getCheckOut());

        return customer;
    }

}
