package com.fitness.socialmediaappfitness.dto.mapper;

import com.fitness.socialmediaappfitness.dto.UserDto;
import com.fitness.socialmediaappfitness.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    public static UserDto toUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFullName(user.getFullName());
        userDto.setImage(user.getImage());
        userDto.setBackgroundImage(user.getBackgroundImage());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setLocation(user.getLocation());
        userDto.setBio(user.getBio());
        userDto.setFollowers(toUserDto(user.getFollowers()));
        userDto.setFollowing(toUserDto(user.getFollowing()));
        userDto.setLogin_with_google(user.isLogin_with_google());
//        userDto.setVerified(false);

        return userDto;
    }

    public static List<UserDto> toUserDto(List<User> followers){
        List<UserDto> userDtos=new ArrayList<>();

        for(User user:followers){
            UserDto userDto=new UserDto();
            userDto.setId(user.getId());
            userDto.setEmail(user.getEmail());
            userDto.setFullName(user.getFullName());
            userDto.setImage(user.getImage());
            userDtos.add(userDto);
        }
        return userDtos;
    }

}
