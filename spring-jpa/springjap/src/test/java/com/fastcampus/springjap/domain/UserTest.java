package com.fastcampus.springjap.domain;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void test(){
        User user = new User();
        user.setEmail("hi465456");
        user.setName("hyungil");

        User user1 = new User();
        System.out.println(user.toString());
    }

}