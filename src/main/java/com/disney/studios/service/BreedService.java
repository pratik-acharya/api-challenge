package com.disney.studios.service;

import com.disney.studios.domain.Breed;

import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
public interface BreedService {
    public Breed save(Breed dog);

    public List<Breed> findByBreed(String breed);



}
