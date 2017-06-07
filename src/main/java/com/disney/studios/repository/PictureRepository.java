package com.disney.studios.repository;

import com.disney.studios.domain.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
public interface PictureRepository extends CrudRepository<Picture,Long> {
    public List<Picture>  findByBreedNameOrderByUpVotesDesc(String breed);
    public  List<Picture> findAllByOrderByUpVotesDesc();
}
