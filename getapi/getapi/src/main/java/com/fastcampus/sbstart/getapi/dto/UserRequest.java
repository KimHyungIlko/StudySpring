package com.fastcampus.sbstart.getapi.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequest {

    private String name;
    private String email;
    private int age;

}
