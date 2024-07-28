package com.fitness.socialmediaappfitness.repository;

import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoostRepository extends JpaRepository<Boost, Long> {

    List<Boost> findAllByIsBoostTrueOrderByCreatedAtDesc();

    List<Boost> findByReBoostUserContainsOrUser_IdAndIsBoostTrueOrderByCreatedAtDesc(User user, Long userId);

    List<Boost> findByLikesContainingOrderByCreatedAtDesc(User user);

    @Query("SELECT b FROM Boost b JOIN b.likes l WHERE l.user.id=:userId")
    List<Boost> findByLikesUser_id(Long userId);
}
