package com.twitter.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.TweetPostDTO;
import com.twitter.api.model.Tweet;
import com.twitter.api.services.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
  @Autowired
  TweetService tweetService;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody TweetPostDTO req) {
    String ans = tweetService.createTweet(req);
    if (ans.equals("error")) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok().body("Ok");
    }
  }

  // @GetMapping
  // public ResponseEntity<Page<Tweet>> listAllTweets(@PageableDefault(page = 0,
  // size = 5) Pageable pageable) {

  // return ResponseEntity.ok().body
  // }

  // @GetMapping("/{username}")
  // public List<Tweet> listAllTweets(@PathVariable String username) {
  // System.out.println(username);
  // List<Tweet> list = tweetRepository.findByUsernameIs(username);
  // System.out.println(list);
  // return tweetRepository.findByUsernameIs(username);
  // }
}
