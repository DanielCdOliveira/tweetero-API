package com.twitter.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.api.dto.UserDTO;
import com.twitter.api.model.User;
import com.twitter.api.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public void createUser(UserDTO newUser) {
    userRepository.save(new User(newUser));
  }
}
