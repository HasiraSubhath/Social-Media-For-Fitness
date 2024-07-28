package com.fitness.socialmediaappfitness.dto;

import lombok.Data;

@Data
public class LikeDto {

    private Long id;
    private UserDto user;
    private BoostDto boost;

}
