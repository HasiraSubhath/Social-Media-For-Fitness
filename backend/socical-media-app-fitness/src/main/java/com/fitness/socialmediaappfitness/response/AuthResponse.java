package com.fitness.socialmediaappfitness.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String jwt;
    private boolean status;
}
