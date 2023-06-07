package com.codegym.hotelmanagement.dto.request;

import lombok.Data;

@Data
public class SearchCustomerRequestDto {
    private String fullName;
    private String phoneNumber;
    private String citizenIdentityCard;
}
