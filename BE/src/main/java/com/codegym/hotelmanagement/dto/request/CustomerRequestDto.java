package com.codegym.hotelmanagement.dto.request;

import lombok.Data;
import java.sql.Date;

@Data
public class CustomerRequestDto {

    private Long id;
    private String fullName;
    private Date dob;
    private String email;
    private Boolean gender;
    private String phoneNumber;
    private String citizenIdentityCard;
    private String specialRequirement;
}
