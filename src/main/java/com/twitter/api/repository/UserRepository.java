package com.twitter.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsernameIs(String name);

}
