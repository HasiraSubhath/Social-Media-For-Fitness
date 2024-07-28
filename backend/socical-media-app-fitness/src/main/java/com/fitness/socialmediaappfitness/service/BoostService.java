package com.fitness.socialmediaappfitness.service;

import com.fitness.socialmediaappfitness.exception.BoostException;
import com.fitness.socialmediaappfitness.exception.UserException;
import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.User;
import com.fitness.socialmediaappfitness.request.BoostReplyRequest;

import java.util.List;

public interface BoostService {

    public Boost createBoost(Boost boost, User user)throws Exception;
    public List<Boost>findAllBoost();
    public Boost reBoost(Long boostId, User user)throws UserException, BoostException;
    public Boost findById(Long boostId) throws BoostException;

    public Boost deleteBoostById(Long boostId, Long user) throws BoostException, UserException;

    public Boost removeFromReBoost(Long boostId, User user) throws BoostException, UserException;

    public Boost createReply(BoostReplyRequest req, User user) throws BoostException, UserException;

    public List<Boost> getUserBoosts(User user);

    public List<Boost> findByLikesContainsUser(User user);

}
