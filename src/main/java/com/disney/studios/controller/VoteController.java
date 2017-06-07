package com.disney.studios.controller;

import com.disney.studios.domain.Picture;
import com.disney.studios.domain.User;
import com.disney.studios.domain.VoteType;
import com.disney.studios.exception.AlreadyVotedException;
import com.disney.studios.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pratik Acharya on 6/7/2017.
 */
@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "/up/user/{user}/picture/{picture}", method = RequestMethod.GET)
    public ResponseEntity<?> voteUp(@PathVariable("user") User user, @PathVariable("picture") Picture picture) throws AlreadyVotedException {

        this.voteService.vote(VoteType.UP, picture, user);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @RequestMapping(value = "/down/user/{user}/picture/{picture}", method = RequestMethod.GET)
    public ResponseEntity<?> voteDown(@PathVariable("user") User user, @PathVariable("picture") Picture picture) throws AlreadyVotedException {

        this.voteService.vote(VoteType.DOWN, picture, user);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
