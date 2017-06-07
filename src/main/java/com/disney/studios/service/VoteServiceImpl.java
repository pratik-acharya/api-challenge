package com.disney.studios.service;

import com.disney.studios.domain.Picture;
import com.disney.studios.domain.User;
import com.disney.studios.domain.Vote;
import com.disney.studios.domain.VoteType;
import com.disney.studios.exception.AlreadyVotedException;
import com.disney.studios.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pratik Acharya on 6/7/2017.
 */
@Service
public class VoteServiceImpl implements  VoteService{
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private PictureService pictureService;

    @Override
    @Transactional
    public void vote(VoteType voteType, Picture picture, User user) throws AlreadyVotedException {
        if(this.hasVoted(user,picture)){
            throw new AlreadyVotedException("You have  already voted for this picture.");
        }else {
            Vote vote = new Vote();
            vote.setUser(user);
            vote.setPicture(picture);
            vote.setVoteType(voteType);
            this.voteRepository.save(vote);

            if (voteType.name().equals("UP")) {
                int upVotes = picture.getUpVotes();
                picture.setUpVotes(upVotes + 1);
            } else {
                int downVotes = picture.getDownVotes();
                picture.setDownVotes(downVotes + 1);
            }
            this.pictureService.save(picture);
        }
    }

    @Override
    public boolean hasVoted(User user, Picture picture) {
        return this.voteRepository.countByUserAndPicture(user, picture)>=1;
    }
}
