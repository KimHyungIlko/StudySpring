package com.fastcampus.sbstart.getapi.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CarDto {

    private String name;
    private String carNumber;
}
