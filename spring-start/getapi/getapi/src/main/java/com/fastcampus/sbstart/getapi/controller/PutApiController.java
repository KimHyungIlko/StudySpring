package com.fastcampus.sbstart.getapi.controller;

import com.fastcampus.sbstart.getapi.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public String put(@RequestBody PutRequestDto putRequestDto, @PathVariable String userId) {
        System.out.println(putRequestDto);
        return putRequestDto.toString().toString();
    }
}
