package com.codegym.hotelmanagement.dto.response;

import lombok.Data;
import java.sql.Date;

@Data
public class CustomerResponseDto {
    private Long id;

    private String fullName;

    private Date dob;

    private String email;

    private Boolean gender;

    private String phoneNumber;

    private String citizenIdentityCard;

    private String specialRequirement;
}
