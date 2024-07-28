package com.fitness.socialmediaappfitness.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WorkoutPlanDto {
    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotEmpty(message = "Routines are required")
    private String routines;

    @NotNull(message = "Sets is required")
    @Min(value = 1, message = "Sets must be at least 1")
    private Integer sets;

    @NotNull(message = "Reps is required")
    @Min(value = 1, message = "Reps must be at least 1")
    private Integer reps;

}