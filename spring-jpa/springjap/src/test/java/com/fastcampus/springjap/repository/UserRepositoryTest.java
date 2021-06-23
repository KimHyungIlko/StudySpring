package com.fastcampus.springjap.repository;

import com.fastcampus.springjap.domain.Gender;
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

    @Test
    void select(){
        //        System.out.println(userRepository.findByName("dennis"));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//
//        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
//        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));

        //System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
       // System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        //System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        //System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "art" + "%"));
    }

    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : "+userRepository.findTop1ByName("martin") );
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

}