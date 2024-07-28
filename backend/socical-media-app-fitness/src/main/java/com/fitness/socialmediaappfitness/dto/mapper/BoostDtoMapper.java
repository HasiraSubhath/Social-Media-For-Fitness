package com.fitness.socialmediaappfitness.dto.mapper;

import com.fitness.socialmediaappfitness.dto.BoostDto;
import com.fitness.socialmediaappfitness.dto.UserDto;
import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.User;
import com.fitness.socialmediaappfitness.util.BoostUtil;

import java.util.ArrayList;
import java.util.List;

public class BoostDtoMapper {

    public static BoostDto toBoostDto(Boost boost, User reqUser){

        UserDto user= UserDtoMapper.toUserDto(boost.getUser());

        boolean isLiked= BoostUtil.isLikedByReqUser(reqUser, boost);
        boolean isReboosted= BoostUtil.isReboostedByReqUser(reqUser, boost);

        List<Long> reBoostUserId=new ArrayList<>();

        for(User user1: boost.getReBoostUser()){
            reBoostUserId.add(user1.getId());
        }

        BoostDto boostDto=new BoostDto();
        boostDto.setId(boost.getId());
        boostDto.setContent(boost.getContent());
        boostDto.setCreatedAt(boost.getCreatedAt());
        boostDto.setImage(boost.getImage());
        boostDto.setTotalLikes(boost.getLikes().size());
        boostDto.setTotalReplies(boost.getReplyBoosts().size());
        boostDto.setTotalReboosts(boost.getReBoostUser().size());
        boostDto.setUser(user);
        boostDto.setLiked(isLiked);
        boostDto.setReboosted(isReboosted);
        boostDto.setReBoostUsersIds(reBoostUserId);
        boostDto.setReplyBoosts(toBoostDtos(boost.getReplyBoosts(), reqUser));
        boostDto.setVideo(boost.getVideo());

        return boostDto;
    }

    public static List<BoostDto> toBoostDtos(List<Boost>boosts, User reqUser) {
        List<BoostDto> boostDtos=new ArrayList<>();

        for(Boost boost:boosts){
            BoostDto boostDto=toReplyBoostDto(boost, reqUser);
            boostDtos.add(boostDto);
        }
        return boostDtos;
    }

    private static BoostDto toReplyBoostDto(Boost boost, User reqUser) {
        UserDto user= UserDtoMapper.toUserDto(boost.getUser());

        boolean isLiked= BoostUtil.isLikedByReqUser(reqUser, boost);
        boolean isReboosted= BoostUtil.isReboostedByReqUser(reqUser, boost);

        List<Long> reBoostUserId=new ArrayList<>();

        for(User user1: boost.getReBoostUser()){
            reBoostUserId.add(user1.getId());
        }

        BoostDto boostDto=new BoostDto();
        boostDto.setId(boost.getId());
        boostDto.setContent(boost.getContent());
        boostDto.setCreatedAt(boost.getCreatedAt());
        boostDto.setImage(boost.getImage());
        boostDto.setTotalLikes(boost.getLikes().size());
        boostDto.setTotalReplies(boost.getReplyBoosts().size());
        boostDto.setTotalReboosts(boost.getReBoostUser().size());
        boostDto.setUser(user);
        boostDto.setLiked(isLiked);
        boostDto.setReboosted(isReboosted);
        boostDto.setReBoostUsersIds(reBoostUserId);
        boostDto.setVideo(boost.getVideo());

        return boostDto;
    }
}
