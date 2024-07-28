package com.fitness.socialmediaappfitness.dto.mapper;

import com.fitness.socialmediaappfitness.dto.BoostDto;
import com.fitness.socialmediaappfitness.dto.LikeDto;
import com.fitness.socialmediaappfitness.dto.UserDto;
import com.fitness.socialmediaappfitness.model.Like;
import com.fitness.socialmediaappfitness.model.User;

import java.util.ArrayList;
import java.util.List;

public class LikeDtoMapper {

    public static LikeDto toLikeDto(Like like, User reqUser){
        UserDto user= UserDtoMapper.toUserDto(like.getUser());
        UserDto reqUserDto = UserDtoMapper.toUserDto(reqUser);
        BoostDto boost = BoostDtoMapper.toBoostDto(like.getBoost(), reqUser);

        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setBoost(boost);
        likeDto.setUser(user);
        return likeDto;
    }

    public static List<LikeDto> toLikeDtoList(List<Like> likes, User reqUser){
        List<LikeDto> likeDtos = new ArrayList<>();

        for(Like like: likes){
            UserDto user= UserDtoMapper.toUserDto(like.getUser());
            BoostDto boost = BoostDtoMapper.toBoostDto(like.getBoost(), reqUser);

            LikeDto likeDto = new LikeDto();
            likeDto.setId(like.getId());
            likeDto.setBoost(boost);
            likeDto.setUser(user);
            likeDtos.add(likeDto);
        }
        return likeDtos;
    }

}
