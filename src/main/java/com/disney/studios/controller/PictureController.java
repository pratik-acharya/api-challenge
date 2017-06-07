package com.disney.studios.controller;

import com.disney.studios.domain.Picture;
import com.disney.studios.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
@RestController
@RequestMapping("/api/pictures")
public class PictureController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureController.class);


    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/breed/{breed}",method = RequestMethod.GET)
    public List<Picture> findDogByBreed(@PathVariable("breed") String breed){
        LOGGER.info(breed);
        return  this.pictureService.findByBreedNameOrderByUpVotes(breed);
    }

    @RequestMapping(method = RequestMethod.GET)
    public HashMap<String,List<Picture>> findGroupedByBreed(){
        return this.pictureService.findAllGroupedByBreedOrderByUpVotes();

    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Picture findById(@PathVariable("id") long id){
        return this.pictureService.findOne(id);
    }



}
