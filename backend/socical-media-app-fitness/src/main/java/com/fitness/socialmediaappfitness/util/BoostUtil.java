package com.fitness.socialmediaappfitness.util;

import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.Like;
import com.fitness.socialmediaappfitness.model.User;

public class BoostUtil {

    public final static boolean isLikedByReqUser(User reqUser, Boost boost){
        for(Like like: boost.getLikes()){
            if(like.getUser().getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;
    }

    public final static boolean isReboostedByReqUser(User reqUser, Boost boost){
        for(User user:boost.getReBoostUser()){
            if(user.getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;
    }

}
