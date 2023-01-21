package com.twitter.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.TweetPostDTO;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

  @PostMapping
  public void create(@RequestBody TweetPostDTO req) {

  }
}
