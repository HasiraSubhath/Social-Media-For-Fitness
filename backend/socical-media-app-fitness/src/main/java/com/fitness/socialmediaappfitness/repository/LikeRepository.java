package com.fitness.socialmediaappfitness.repository;

import com.fitness.socialmediaappfitness.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT l FROM Like l WHERE l.user.id=:userId AND l.boost.id=:boostId")
    public Like isLikeExist(@Param("userId")Long userId, @Param("boostId")Long boostId);

    @Query("SELECT l FROM Like l WHERE l.boost.id=:boostId")
    public List<Like> findByBoostId(@Param("boostId")Long boostId);

}
