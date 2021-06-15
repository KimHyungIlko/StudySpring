package com.fastcampus.sbstart.getapi.controller;

import com.fastcampus.sbstart.getapi.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello") //http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }

    @RequestMapping(path="/hi", method= RequestMethod.GET) //http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";
    }

    @GetMapping(path="/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("path variable : "+name);
        return name;
    }

    //http://localhost:8080/api/get/query-param?user=steve&email=martin@fastcampus.com&age=29
    @GetMapping(path="/query-param")
    public String queryParm(UserRequest user){
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getAge());
        return user.toString();
    }

}
