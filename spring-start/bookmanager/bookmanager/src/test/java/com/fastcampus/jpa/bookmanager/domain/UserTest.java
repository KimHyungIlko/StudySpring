package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");


        User user2 = new User("martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
        System.out.println(">>>" + user2);
    }
}