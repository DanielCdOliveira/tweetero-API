package com.twitter.api.interfaces;

public class PostTweet {

  public PostTweet(String username, String text) {
    this.username = username;
    this.text = text;
  }

  String username;
  String text;

  public String getUsername() {
    return username;
  }

  public String getText() {
    return text;
  }
}
