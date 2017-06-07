package com.disney.studios.service;

import com.disney.studios.domain.Picture;
import com.disney.studios.domain.User;
import com.disney.studios.domain.VoteType;
import com.disney.studios.exception.AlreadyVotedException;

/**
 * Created by Pratik Acharya on 6/7/2017.
 */
public interface VoteService {
    public void vote(VoteType voteType, Picture picture, User user) throws AlreadyVotedException;

    public  boolean hasVoted(User user,Picture picture);
}
