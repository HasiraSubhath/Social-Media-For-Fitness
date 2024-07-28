package com.fitness.socialmediaappfitness.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
//with getters and setters
/*
@Entity
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String routines; // You may need to adjust this field based on the structure of your routines

    // Constructors, getters, and setters
    // Constructor(s)
    public WorkoutPlan() {}

    public WorkoutPlan(String name, String description, String routines) {
        this.name = name;
        this.description = description;
        this.routines = routines;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoutines() {
        return routines;
    }

    public void setRoutines(String routines) {
        this.routines = routines;
    }
}
*/

@Entity
@Data
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String routines;
    private Integer sets;
    private Integer reps;

    // Define relationship with User entity
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
/*
    // Constructors, getters, and setters
    public WorkoutPlan() {}

    public WorkoutPlan(String name, String description, String routines) {
        this.name = name;
        this.description = description;
        this.routines = routines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoutines() {
        return routines;
    }

    public void setRoutines(String routines) {
        this.routines = routines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


*/