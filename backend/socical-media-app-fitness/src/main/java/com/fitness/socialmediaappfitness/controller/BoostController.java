package com.fitness.socialmediaappfitness.controller;

import com.fitness.socialmediaappfitness.dto.BoostDto;
import com.fitness.socialmediaappfitness.dto.mapper.BoostDtoMapper;
import com.fitness.socialmediaappfitness.exception.BoostException;
import com.fitness.socialmediaappfitness.exception.UserException;
import com.fitness.socialmediaappfitness.model.Boost;
import com.fitness.socialmediaappfitness.model.User;
import com.fitness.socialmediaappfitness.request.BoostReplyRequest;
import com.fitness.socialmediaappfitness.response.ApiResponse;
import com.fitness.socialmediaappfitness.service.BoostService;
import com.fitness.socialmediaappfitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boost")
public class BoostController {

    @Autowired
    private BoostService boostService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<BoostDto> createBoost(@RequestBody Boost req, @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserProfileByJwt(jwt);

        Boost boost=boostService.createBoost(req, user);

        BoostDto boostDto= BoostDtoMapper.toBoostDto(boost, user);

        return new ResponseEntity<>(boostDto, HttpStatus.CREATED);

    }

    @PostMapping("/reply")
    public ResponseEntity<BoostDto> replyBoost(@RequestBody BoostReplyRequest req, @RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        Boost boost=boostService.createReply(req, user);

        BoostDto boostDto= BoostDtoMapper.toBoostDto(boost, user);

        return new ResponseEntity<>(boostDto, HttpStatus.CREATED);

    }

    @PutMapping("/{boostId}/reBoost")
    public ResponseEntity<BoostDto> reBoost(@PathVariable Long boostId, @RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        Boost boost=boostService.reBoost(boostId, user);

        BoostDto boostDto= BoostDtoMapper.toBoostDto(boost, user);

        return new ResponseEntity<>(boostDto, HttpStatus.OK);

    }

    @GetMapping("/{boostId}")
    public ResponseEntity<BoostDto> findBoostById(@PathVariable Long boostId, @RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        Boost boost=boostService.findById(boostId);

        BoostDto boostDto= BoostDtoMapper.toBoostDto(boost, user);

        return new ResponseEntity<>(boostDto, HttpStatus.OK);

    }

    @DeleteMapping("/{boostId}")
    public ResponseEntity<ApiResponse> deleteBoost(@PathVariable Long boostId, @RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        boostService.deleteBoostById(boostId, user.getId());

        ApiResponse res=new ApiResponse();
        res.setMessage("Boost deleted successfully");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<BoostDto>> getAllBoosts(@RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        List<Boost> boosts=boostService.findAllBoost();

        List<BoostDto> boostDto= BoostDtoMapper.toBoostDtos(boosts, user);

        return new ResponseEntity<>(boostDto, HttpStatus.OK);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BoostDto>> getUserAllBoosts(@PathVariable Long userId, @RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        List<Boost> boosts=boostService.getUserBoosts(user);

        List<BoostDto> boostDto= BoostDtoMapper.toBoostDtos(boosts, user);

        return new ResponseEntity<>(boostDto, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/likes")
    public ResponseEntity<List<BoostDto>> findBoostByLikesContainsUser(@PathVariable Long userId, @RequestHeader("Authorization") String jwt)throws UserException, BoostException {
        User user=userService.findUserProfileByJwt(jwt);

        List<Boost> boosts=boostService.findByLikesContainsUser(user);

        List<BoostDto> boostDto= BoostDtoMapper.toBoostDtos(boosts, user);

        return new ResponseEntity<>(boostDto, HttpStatus.OK);
    }

}
