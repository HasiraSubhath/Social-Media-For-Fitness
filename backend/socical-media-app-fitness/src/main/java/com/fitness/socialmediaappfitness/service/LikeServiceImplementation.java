package com.fitness.socialmediaappfitness.service;

import com.fitness.socialmediaappfitness.exception.BoostException;
import com.fitness.socialmediaappfitness.exception.UserException;
import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.Like;
import com.fitness.socialmediaappfitness.model.User;
import com.fitness.socialmediaappfitness.repository.BoostRepository;
import com.fitness.socialmediaappfitness.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImplementation implements LikeService{

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private BoostService boostService;

    @Autowired
    private BoostRepository boostRepository;

    @Override
    public Like likeBoost(Long boostId, User user) throws BoostException, UserException {
        Like isLikeExist=likeRepository.isLikeExist(user.getId(), boostId);

        if(isLikeExist!=null){
            likeRepository.deleteById(isLikeExist.getId());
            return isLikeExist;
        }
        Boost boost=boostService.findById(boostId);

        Like like=new Like();
        like.setBoost(boost);
        like.setUser(user);

        Like savedLike=likeRepository.save(like);

        boost.getLikes().add(savedLike);
        boostRepository.save(boost);

        return savedLike;
    }

    @Override
    public List<Like> getAllLikes(Long boostId) throws BoostException {
        Boost boost=boostService.findById(boostId);

        List<Like> likes=likeRepository.findByBoostId(boostId);

        return likes;
    }
}
