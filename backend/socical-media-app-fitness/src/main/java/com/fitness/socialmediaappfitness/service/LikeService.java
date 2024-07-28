package com.fitness.socialmediaappfitness.service;

import com.fitness.socialmediaappfitness.exception.BoostException;
import com.fitness.socialmediaappfitness.exception.UserException;
import com.fitness.socialmediaappfitness.model.Like;
import com.fitness.socialmediaappfitness.model.User;

import java.util.List;

public interface LikeService {

    public Like likeBoost(Long boostId, User user) throws BoostException, UserException;

    public List<Like> getAllLikes(Long boostId) throws BoostException;

}
