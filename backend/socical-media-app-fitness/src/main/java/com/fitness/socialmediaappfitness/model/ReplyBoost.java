package com.fitness.socialmediaappfitness.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReplyBoost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Boost boost;
}
