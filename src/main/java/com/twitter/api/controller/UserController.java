package com.twitter.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.UserDTO;
import com.twitter.api.model.User;
import com.twitter.api.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class UserController {
  @Autowired
  private UserRepository repository;

  @PostMapping("/sign-up")
  public void create(@RequestBody UserDTO req) {
    System.out.println(req);
    repository.save(new User(req));
  }

  @GetMapping
  public List<User> listAll() {
    return repository.findAll();
  }
}
