package com.codegym.hotelmanagement.dto.response;

import lombok.*;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private Boolean isDelete;
}
