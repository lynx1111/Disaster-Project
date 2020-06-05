package com.summit.drproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.drproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
