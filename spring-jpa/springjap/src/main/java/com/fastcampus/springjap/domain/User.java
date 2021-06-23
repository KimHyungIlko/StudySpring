package com.fastcampus.springjap.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
public class User {
    @Id //PK 지정 어노테이션
    @GeneratedValue //GeneratedValue : 저절로 생성된 값을 넣는다 따로 값 설정을 안해도 됨.
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

//    @OneToMany(fetch= FetchType.EAGER)
//    private List<Address> address;

    @Transient
    private String testData;

}
