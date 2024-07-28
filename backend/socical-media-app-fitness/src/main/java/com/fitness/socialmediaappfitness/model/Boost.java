package com.fitness.socialmediaappfitness.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Boost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String content;
    private String image;
    private String video;

    @OneToMany(mappedBy = "boost", cascade = CascadeType.ALL)
    private List<Like> likes=new ArrayList<>();

    @OneToMany(mappedBy = "parentBoost", cascade = CascadeType.ALL)
    private List<Boost> replyBoosts=new ArrayList<>();

    @ManyToMany
    private List<User> reBoostUser=new ArrayList<>();

    @ManyToOne
    private Boost parentBoost;

    private boolean isReply;
    private boolean isBoost;

    private LocalDateTime createdAt;

}
