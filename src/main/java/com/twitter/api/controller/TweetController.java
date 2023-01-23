package com.twitter.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.TweetPostDTO;
import com.twitter.api.interfaces.PostTweet;
import com.twitter.api.model.Tweet;
import com.twitter.api.services.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
  @Autowired
  TweetService tweetService;

  @PostMapping
  public ResponseEntity<String> create(@RequestHeader("User") String username, @RequestBody TweetPostDTO req) {
    PostTweet postTweet = new PostTweet(username, req.text());
    String ans = tweetService.createTweet(postTweet);
    if (ans.equals("error")) {
      return ResponseEntity.status(404).build();
    } else {
      return ResponseEntity.status(201).body("OK");
    }
  }

  @GetMapping
  public ResponseEntity<Page<Tweet>> getLastTweets(@RequestParam(value = "page") int page) {
    return ResponseEntity.ok().body(tweetService.getLastTweets(page));
  }

  @GetMapping("/{username}")
  public List<Tweet> listAllTweetsFromUser(@PathVariable String username) {
    return tweetService.getAllTweetsFromUser(username);
  }
}
