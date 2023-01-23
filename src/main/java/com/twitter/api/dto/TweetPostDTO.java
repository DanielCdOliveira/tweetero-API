package com.twitter.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetPostDTO(
        @NotBlank String text) {

}
