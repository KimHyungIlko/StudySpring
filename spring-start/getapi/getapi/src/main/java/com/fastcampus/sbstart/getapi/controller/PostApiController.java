package com.fastcampus.sbstart.getapi.controller;

import com.fastcampus.sbstart.getapi.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, String> requestData) {

        requestData.entrySet().forEach(stringStringEntry -> {
            System.out.println("key : " + stringStringEntry.getKey());
            System.out.println("value : " + stringStringEntry.getValue());
        });
    }

    @PostMapping("/post1")
    public void post1(@RequestBody PostRequestDto postRequestDto) {

        System.out.println(postRequestDto);

    }
}
