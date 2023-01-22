package com.twitter.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  List<Tweet> findByUsernameIs(String name);

}
