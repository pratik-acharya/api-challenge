package com.disney.studios.service;

import com.disney.studios.domain.Picture;
import com.disney.studios.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public Picture save(Picture picture) {
        return this.pictureRepository.save(picture);
    }

    @Override
    public List<Picture> findByBreedNameOrderByUpVotes(String breed) {
        return this.pictureRepository.findByBreedNameOrderByUpVotesDesc(breed);
    }

    @Override
    public HashMap<String,List<Picture>> findAllGroupedByBreedOrderByUpVotes() {
        List<Picture> pictureList =  this.pictureRepository.findAllByOrderByUpVotesDesc();
        HashMap<String,List<Picture>> breedPictures = new HashMap<>();
        pictureList.forEach((picture -> {
            String breed = picture.getBreed().getName();
            if(!breedPictures.containsKey(breed)){
                breedPictures.put(breed, new ArrayList<Picture>(){
                    {
                        add(picture);
                    }
                });
            }else{
               breedPictures.get(breed).add(picture);
            }

        }));

        return  breedPictures;
    }



    @Override
    public Picture findOne(long id) {
        return this.pictureRepository.findOne(id);
    }
}
