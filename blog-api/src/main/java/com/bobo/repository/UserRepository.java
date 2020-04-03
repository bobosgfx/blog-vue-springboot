package com.bobo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);


}
