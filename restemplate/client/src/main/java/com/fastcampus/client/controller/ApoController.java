package com.fastcampus.client.controller;

import com.fastcampus.client.dto.UserResponse;
import com.fastcampus.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApoController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/hello")
    public UserResponse getHello(){

        return restTemplateService.problem();
    }
}
