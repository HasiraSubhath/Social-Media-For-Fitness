package com.fitness.socialmediaappfitness.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoostDto {

    private Long id;
    private String content;
    private String image;
    private String video;
    private UserDto user;
    private LocalDateTime createdAt;
    private int totalLikes;
    private int totalReplies;
    private int totalReboosts;
    private boolean isLiked;
    private boolean isReboosted;

    private List<Long>reBoostUsersIds;
    private List<BoostDto>reBoosts;
    private List<BoostDto> replyBoosts;

}
