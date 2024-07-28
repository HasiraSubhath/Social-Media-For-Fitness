package com.fitness.socialmediaappfitness.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoostReplyRequest {

    private String content;
    private Long boostid;
    private LocalDateTime createdAt;
    private String image;

}
