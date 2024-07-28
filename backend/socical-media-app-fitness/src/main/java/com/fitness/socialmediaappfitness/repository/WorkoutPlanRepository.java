package com.fitness.socialmediaappfitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fitness.socialmediaappfitness.model.WorkoutPlan;
@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    // You can add custom query methods here if needed
}
