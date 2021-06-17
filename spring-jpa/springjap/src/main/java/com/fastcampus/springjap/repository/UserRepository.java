package com.fastcampus.springjap.repository;

import com.fastcampus.springjap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
