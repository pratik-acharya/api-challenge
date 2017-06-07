package com.disney.studios.repository;

import com.disney.studios.domain.Picture;
import com.disney.studios.domain.User;
import com.disney.studios.domain.Vote;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
public interface VoteRepository extends CrudRepository<Vote,Long>{
    public  int countByUserAndPicture(User user, Picture picture);

}
