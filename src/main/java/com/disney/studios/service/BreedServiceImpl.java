package com.disney.studios.service;

import com.disney.studios.domain.Breed;
import com.disney.studios.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
@Service
public class BreedServiceImpl implements BreedService {
    @Autowired
    private BreedRepository breedRepository;

    @Override
    public Breed save(Breed dog) {
        return this.breedRepository.save(dog);
    }

    @Override
    public List<Breed> findByBreed(String breed) {
        return this.breedRepository.findByName(breed);
    }




}
