package com.fitness.socialmediaappfitness.service;

import com.fitness.socialmediaappfitness.exception.BoostException;
import com.fitness.socialmediaappfitness.exception.UserException;
import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.User;
import com.fitness.socialmediaappfitness.repository.BoostRepository;
import com.fitness.socialmediaappfitness.request.BoostReplyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public
class BoostServiceImplementation implements BoostService{

    @Autowired
    private BoostRepository boostRepository;

    @Override
    public Boost createBoost(Boost req, User user) throws UserException {
        Boost boost=new Boost();
        boost.setContent(req.getContent());
        boost.setCreatedAt(LocalDateTime.now());
        boost.setImage(req.getImage());
        boost.setUser(user);
        boost.setReply(false);
        boost.setBoost(true);
        boost.setVideo(req.getVideo());
        return boostRepository.save(boost);
    }

    @Override
    public List<Boost> findAllBoost() {
        return boostRepository.findAllByIsBoostTrueOrderByCreatedAtDesc();
    }

    @Override
    public Boost reBoost(Long boostId, User user) throws UserException, BoostException {
        Boost boost=findById(boostId);
        if(boost.getReBoostUser().contains(user)){
            boost.getReBoostUser().remove(user);
        }else{
            boost.getReBoostUser().add(user);
        }
        return boostRepository.save(boost);
    }

    @Override
    public Boost findById(Long boostId) throws BoostException {
        Boost boost=boostRepository.findById(boostId).orElseThrow(()->new BoostException("Boost not found with id"+boostId));
        return boost;
    }

    @Override
    public Boost deleteBoostById(Long boostId, Long userId) throws BoostException, UserException {
        Boost boost=findById(boostId);
        if(!boostId.equals(boost.getUser().getId())){
            throw new UserException("User not found");
        }
        boostRepository.deleteById(boost.getId());
        return boost;
    }

    @Override
    public Boost removeFromReBoost(Long boostId, User user) throws BoostException, UserException {
        return null;
    }

    @Override
    public Boost createReply(BoostReplyRequest req, User user) throws BoostException {

        Boost replyFor= findById(req.getBoostid());

        Boost boost=new Boost();
        boost.setContent(req.getContent());
        boost.setCreatedAt(LocalDateTime.now());
        boost.setImage(req.getImage());
        boost.setUser(user);
        boost.setReply(true);
        boost.setBoost(false);
        boost.setParentBoost(replyFor);

        Boost savedReply=boostRepository.save(boost);

        boost.getReplyBoosts().add(savedReply);
        boostRepository.save(replyFor);

        return replyFor;
    }

    @Override
    public List<Boost> getUserBoosts(User user) {
        return boostRepository.findByReBoostUserContainsOrUser_IdAndIsBoostTrueOrderByCreatedAtDesc(user, user.getId());
    }

    @Override
    public List<Boost> findByLikesContainsUser(User user) {
        return boostRepository.findByLikesUser_id(user.getId());
    }

}
