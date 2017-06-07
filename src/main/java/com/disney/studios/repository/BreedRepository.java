package com.disney.studios.repository;

import com.disney.studios.domain.Breed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
public interface BreedRepository extends CrudRepository<Breed,Long> {
    public List<Breed> findByName(String breed);


}
