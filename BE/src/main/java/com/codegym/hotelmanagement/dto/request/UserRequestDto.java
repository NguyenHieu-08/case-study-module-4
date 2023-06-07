package com.codegym.hotelmanagement.dto.request;

import lombok.*;

@Data
public class UserRequestDto {
    private Long id;
    private String username;
    private String password;
    private Boolean isDelete;
}
