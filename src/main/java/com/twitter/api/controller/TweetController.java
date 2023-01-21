package com.twitter.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.api.dto.TweetDTO;
import com.twitter.api.dto.TweetPostDTO;
import com.twitter.api.model.Tweet;
import com.twitter.api.model.User;
import com.twitter.api.repository.TweetRepository;
import com.twitter.api.repository.UserRepository;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
  @Autowired
  private TweetRepository tweetRepository;
  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public String create(@RequestBody TweetPostDTO req) {
    User user = userRepository.findByUsernameIs(req.username()).get(0);
    TweetDTO tweet = new TweetDTO(req.username(), user.getAvatar(), req.tweet());
    tweetRepository.save(new Tweet(tweet));
    return "OK";
  }

  @GetMapping("/{username}")
  public List<Tweet> listAllTweets(@PathVariable String username) {
    return tweetRepository.findByUsernameIs(username);
  }
}
