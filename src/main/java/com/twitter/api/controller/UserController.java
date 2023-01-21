package com.twitter.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.UserDTO;

@RestController
@RequestMapping("/api/auth")
public class UserController {
  @PostMapping("/sign-up")
  public void create(@RequestBody UserDTO req) {
    System.out.println(req);
  }
}
