//package com.fitness.socialmediaappfitness.controller;
//
//
//import com.fitness.socialmediaappfitness.dto.WorkoutPlanDto;
//
//import com.fitness.socialmediaappfitness.model.WorkoutPlan;
//import com.fitness.socialmediaappfitness.repository.WorkoutPlanRepository;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/workout-plans")
//public class WorkoutPlanController {
//
//    @Autowired
//    private WorkoutPlanRepository workoutPlanRepository;
//
//    // Get all workout plans
////    @GetMapping
////    public ResponseEntity<CollectionModel<EntityModel<WorkoutPlan>>> getAllWorkoutPlans() {
////        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findAll();
////        return ResponseEntity.ok(getWorkoutPlansResource(workoutPlans));
////    }
//
//    @GetMapping
//    public List<WorkoutPlan> getAllWorkoutPlans() {
//        return workoutPlanRepository.findAll();
//    }
//
//    // Get a specific workout plan by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<WorkoutPlan> getWorkoutPlanById(@PathVariable(value = "id") Long workoutPlanId) {
//        return workoutPlanRepository.findById(workoutPlanId)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
////    @GetMapping("/{id}")
////    public ResponseEntity<EntityModel<WorkoutPlan>> getWorkoutPlanById(@PathVariable(value = "id") Long workoutPlanId) {
////        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(workoutPlanId);
////        return workoutPlanOptional.map(workoutPlan -> ResponseEntity.ok(getWorkoutPlanResource(workoutPlan)))
////                .orElseGet(() -> ResponseEntity.notFound().build());
////    }
//
//   // Create a new workout plan
//
//    @PostMapping
//    public ResponseEntity<?> createWorkoutPlan(
//            @Valid @RequestBody WorkoutPlanDto workoutPlanDto,
//            BindingResult result
//    ) {
//        if (result.hasErrors()) {
//            var errorsList = result.getAllErrors();
//            var errorsMap = new HashMap<String, String>();
//
//            for (int i = 0; i < errorsList.size(); i++) {
//                var error = (FieldError) errorsList.get(i);
//                errorsMap.put(error.getField(), error.getDefaultMessage());
//            }
//            return ResponseEntity.badRequest().body(errorsMap);
//        }
//        WorkoutPlan workoutPlan = new WorkoutPlan();
//        workoutPlan.setName(workoutPlanDto.getName());
//        workoutPlan.setDescription(workoutPlanDto.getDescription());
//        workoutPlan.setRoutines(workoutPlanDto.getRoutines());
//
//        workoutPlanRepository.save(workoutPlan);
//
//        return ResponseEntity.ok(workoutPlan);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<?> updateWorkoutPlan(
//            @PathVariable Long id,
//            @Valid @RequestBody WorkoutPlanDto workoutPlanDto,
//            BindingResult result
//    ) {
//        if (result.hasErrors()) {
//            var errorsList = result.getAllErrors();
//            var errorsMap = new HashMap<String, String>();
//
//            for (int i = 0; i < errorsList.size(); i++) {
//                var error = (FieldError) errorsList.get(i);
//                errorsMap.put(error.getField(), error.getDefaultMessage());
//            }
//            return ResponseEntity.badRequest().body(errorsMap);
//        }
//        WorkoutPlan workoutPlan = workoutPlanRepository.findById(id).orElse(null);
//        if (workoutPlan == null) {
//            return ResponseEntity.notFound().build();
//        }
//        workoutPlan.setName(workoutPlanDto.getName());
//        workoutPlan.setDescription(workoutPlanDto.getDescription());
//        workoutPlan.setRoutines(workoutPlanDto.getRoutines());
//
//        workoutPlanRepository.save(workoutPlan);
//
//        return ResponseEntity.ok(workoutPlan);
//    }
////    public ResponseEntity<EntityModel<WorkoutPlan>> createWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
////        WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(workoutPlan);
////        return ResponseEntity
////                .created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getWorkoutPlanById(savedWorkoutPlan.getId())).toUri())
////                .body(getWorkoutPlanResource(savedWorkoutPlan));
////    }
////
////    // Update an existing workout plan
////    @PutMapping("/{id}")
////    public ResponseEntity<EntityModel<WorkoutPlan>> updateWorkoutPlan(@PathVariable(value = "id") Long workoutPlanId,
////                                                                      @RequestBody WorkoutPlan updatedWorkoutPlan) {
////        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(workoutPlanId);
////        if (workoutPlanOptional.isPresent()) {
////            WorkoutPlan existingWorkoutPlan = workoutPlanOptional.get();
////            existingWorkoutPlan.setName(updatedWorkoutPlan.getName());
////            existingWorkoutPlan.setDescription(updatedWorkoutPlan.getDescription());
////            existingWorkoutPlan.setRoutines(updatedWorkoutPlan.getRoutines());
////            WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(existingWorkoutPlan);
////            return ResponseEntity.ok(getWorkoutPlanResource(savedWorkoutPlan));
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////     Delete a workout plan
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable(value = "id") Long workoutPlanId) {
//        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(workoutPlanId);
//        if (workoutPlanOptional.isPresent()) {
//            workoutPlanRepository.delete(workoutPlanOptional.get());
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
////    // Helper method to create workout plan resource with links
////    private EntityModel<WorkoutPlan> getWorkoutPlanResource(WorkoutPlan workoutPlan) {
////        return EntityModel.of(workoutPlan,
////                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getWorkoutPlanById(workoutPlan.getId())).withSelfRel(),
////                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getAllWorkoutPlans()).withRel("workout-plans"));
////    }
////
////    // Helper method to create workout plans resource with links
////    private CollectionModel<EntityModel<WorkoutPlan>> getWorkoutPlansResource(List<WorkoutPlan> workoutPlans) {
////        return CollectionModel.of(workoutPlans.stream().map(this::getWorkoutPlanResource).toList(),
////                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getAllWorkoutPlans()).withSelfRel());
////    }
//}


package com.fitness.socialmediaappfitness.controller;
import com.fitness.socialmediaappfitness.model.WorkoutPlan;
import com.fitness.socialmediaappfitness.repository.WorkoutPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fitness.socialmediaappfitness.dto.WorkoutPlanDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;

@RestController
@RequestMapping("/api/workout-plans")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    // Get all workout plans
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<WorkoutPlan>>> getAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findAll();
        return ResponseEntity.ok(getWorkoutPlansResource(workoutPlans));
    }

    // Get  workout plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<WorkoutPlan>> getWorkoutPlanById(@PathVariable(value = "id") Long workoutPlanId) {
        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(workoutPlanId);
        return workoutPlanOptional.map(workoutPlan -> ResponseEntity.ok(getWorkoutPlanResource(workoutPlan)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new workout plan
//    @PostMapping
//    public ResponseEntity<EntityModel<WorkoutPlan>> createWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
//        WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(workoutPlan);
//        return ResponseEntity
//                .created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getWorkoutPlanById(savedWorkoutPlan.getId())).toUri())
//                .body(getWorkoutPlanResource(savedWorkoutPlan));
//    }
    // Create a new workout plan
    @PostMapping
    public ResponseEntity<?> createWorkoutPlan(@Valid @RequestBody WorkoutPlanDto workoutPlanDto, BindingResult result) {
        if (result.hasErrors()) {
            var errorsMap = new HashMap<String, String>();
            for (FieldError error : result.getFieldErrors()) {
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorsMap);
        }
        // Map WorkoutPlanDto to WorkoutPlan entity
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setName(workoutPlanDto.getName());
        workoutPlan.setDescription(workoutPlanDto.getDescription());
        workoutPlan.setRoutines(workoutPlanDto.getRoutines());
        workoutPlan.setReps(workoutPlanDto.getReps());
        workoutPlan.setSets(workoutPlanDto.getSets());

        // Save the mapped entity
        WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(workoutPlan);

        // Return the saved entity with appropriate response
        return ResponseEntity
                .created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getWorkoutPlanById(savedWorkoutPlan.getId())).toUri())
                .body(getWorkoutPlanResource(savedWorkoutPlan));
    }

    // Update an existing workout plan
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<WorkoutPlan>> updateWorkoutPlan(@PathVariable(value = "id") Long workoutPlanId,
                                                                      @RequestBody WorkoutPlan updatedWorkoutPlan) {
        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(workoutPlanId);
        if (workoutPlanOptional.isPresent()) {
            WorkoutPlan existingWorkoutPlan = workoutPlanOptional.get();
            existingWorkoutPlan.setName(updatedWorkoutPlan.getName());
            existingWorkoutPlan.setDescription(updatedWorkoutPlan.getDescription());
            existingWorkoutPlan.setRoutines(updatedWorkoutPlan.getRoutines());
            existingWorkoutPlan.setReps(updatedWorkoutPlan.getReps());
            existingWorkoutPlan.setSets(updatedWorkoutPlan.getSets());
            WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(existingWorkoutPlan);
            return ResponseEntity.ok(getWorkoutPlanResource(savedWorkoutPlan));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a workout plan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable(value = "id") Long workoutPlanId) {
        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(workoutPlanId);
        if (workoutPlanOptional.isPresent()) {
            workoutPlanRepository.delete(workoutPlanOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Helper method to create workout plan resource with links
    private EntityModel<WorkoutPlan> getWorkoutPlanResource(WorkoutPlan workoutPlan) {
        return EntityModel.of(workoutPlan,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getWorkoutPlanById(workoutPlan.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getAllWorkoutPlans()).withRel("workout-plans"));
    }

    // Helper method to create workout plans resource with links
    private CollectionModel<EntityModel<WorkoutPlan>> getWorkoutPlansResource(List<WorkoutPlan> workoutPlans) {
        return CollectionModel.of(workoutPlans.stream().map(this::getWorkoutPlanResource).toList(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkoutPlanController.class).getAllWorkoutPlans()).withSelfRel());
    }
}
