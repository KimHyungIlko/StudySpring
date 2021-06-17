package com.fastcampus.springjap.repository;

import com.fastcampus.springjap.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud(){
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));

        List<User> users1 = userRepository.findAllById(Lists.newArrayList(1L,3l,5l));

        User user2 = new User("jack", "hi465465@naver.com");
        User user3 = new User("steve", "steve@hellow.com");
        userRepository.saveAll(Lists.newArrayList(user2,user3));
        List<User> users2 = userRepository.findAll();

        User user4 = userRepository.getOne(1L);
        //System.out.println(user4);

        User user5 = userRepository.findById(1L).orElse(null);
        System.out.println(user5);

        userRepository.save(new User("new martin","hyungil@cnrk.com"));
        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);

        //list 카운트
        long count = userRepository.count();
        System.out.println(">>>>>>"+count);

        //userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

        /////////////////////Delete Source
        //userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L))); // 하나씩 하나씩 다지움
        //userRepository.deleteAllInBatch(); // 한 번에 다지움
        //userRepository.findAll().forEach(System.out::println);

        //조회 처리
        Page<User> users7 = userRepository.findAll(PageRequest.of(1,3));
        System.out.println("page : "+users7);
        System.out.println("totalElements : "+users7.getTotalElements());
        System.out.println("totalPges : "+users7.getTotalPages());
        System.out.println("numberOffElements : "+users7.getNumberOfElements());
        System.out.println("sort : "+users7.getSort());
        System.out.println("size : "+users7.getSize());
        //users7.getContent().forEach(System.out::println);

        //자주 사용하는 방식은 아님 아래방법을 많이사용
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());
        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);
        //userRepository.findAll(example).forEach(System.out::println);

        //많이사용하는 Matcher 방법
        User user = new User();
        user.setEmail("slow");
        ExampleMatcher matcher2 = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example2 = Example.of(user,matcher2);
        userRepository.findAll(example2).forEach(System.out::println);

        //users2.forEach(System.out::println);
//        userRepository.save(new User());
//        userRepository.findAll().forEach(System.out::println);
    //////////////////////////////////UPDATE Source
    userRepository.save(new User("david","david@fastcampus.com"));
    User user6 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
    user6.setEmail("martin-update@fastcampus.com");
    userRepository.save(user6);
    userRepository.findAll().forEach(System.out::println);

    }

}