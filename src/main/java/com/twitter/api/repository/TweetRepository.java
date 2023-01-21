package com.twitter.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
