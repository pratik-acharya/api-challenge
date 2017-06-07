package com.disney.studios.service;

import com.disney.studios.domain.Picture;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
public interface PictureService {

    public Picture save(Picture picture);

    public List<Picture> findByBreedNameOrderByUpVotes(String breed);

    public HashMap<String,List<Picture>> findAllGroupedByBreedOrderByUpVotes();

    public Picture findOne(long id);

}
