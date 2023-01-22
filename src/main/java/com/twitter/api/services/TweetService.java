package com.twitter.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

  public Page<Tweet> getLastTweets(int page) {
    Pageable pageable = PageRequest.of(page, 5);
    return tweetRepository.findAll(pageable);
  }

  public List<Tweet> getAllTweetsFromUser(String username) {
    return tweetRepository.findByUsernameIs(username);
  }
}
