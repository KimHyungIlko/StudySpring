package com.fastcampus.client.service;

import com.fastcampus.client.dto.UserRequest;
import com.fastcampus.client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","steve")
                .queryParam("age",20)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate resstTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = resstTemplate.getForEntity(uri, UserResponse.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse problem(){
        //http://localhost:9090/api/server/user/{userId}

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode().build()
                .expand("100","steve")
                .toUri();
        System.out.println(uri);

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);
        RestTemplate restTemplate = new RestTemplate();
        //뭐가 문제일까?
        ResponseEntity<UserResponse> response=restTemplate.postForEntity(uri,req,UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();

    }
}
