package com.twitter.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.api.dto.TweetDTO;
import com.twitter.api.dto.TweetPostDTO;
import com.twitter.api.model.Tweet;
import com.twitter.api.model.User;
import com.twitter.api.repository.TweetRepository;
import com.twitter.api.repository.UserRepository;

@Service
public class TweetService {
  @Autowired
  TweetRepository tweetRepository;
  @Autowired
  UserRepository userRepository;

  public String createTweet(TweetPostDTO tweet) {
    User user = userRepository.findByUsernameIs(tweet.username()).get(0);
    if (user == null) {
      return "error";
    } else {
      Tweet newTweet = new Tweet(tweet.username(), user.getAvatar(), tweet.tweet());
      tweetRepository.save(newTweet);
      return "OK";
    }
  }
}
