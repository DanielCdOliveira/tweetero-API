package com.twitter.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByUsernameIs(String name);

}
