package com.twitter.api.model;

import com.twitter.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
  public Tweet(TweetDTO data) {
    this.username = data.username();
    this.avatar = data.avatar();
    this.text = data.text();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length = 100, nullable = false)
  private String username;
  @Column(length = 5000, nullable = false)
  private String avatar;
  @Column(length = 500, nullable = false)
  private String text;
}
