package com.fastcampus.sbstart.getapi.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {

    private String name;
    private int age;
    private List<CarDto> carList;
}
