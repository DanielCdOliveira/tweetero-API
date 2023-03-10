package com.twitter.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.UserDTO;
import com.twitter.api.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/sign-up")
  public String create(@RequestBody UserDTO req) {
    userService.createUser(req);
    return "OK";
  }
}
