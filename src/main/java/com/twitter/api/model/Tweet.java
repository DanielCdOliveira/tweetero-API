package com.twitter.api.model;

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
  public Tweet(String username, String avatar, String text) {
    this.username = username;
    this.avatar = avatar;
    this.text = text;
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
