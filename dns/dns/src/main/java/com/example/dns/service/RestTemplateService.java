package com.example.dns.service;

import java.net.URI;

import com.example.dns.dto.UserResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {

    public UserResponse hello() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").path("/api/server/hello")
                .queryParam("name", "steve").queryParam("age", 20).encode().build().toUri();

        System.out.println(uri.toString());

        RestTemplate resstTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = resstTemplate.getForEntity(uri, UserResponse.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();

    }

}
