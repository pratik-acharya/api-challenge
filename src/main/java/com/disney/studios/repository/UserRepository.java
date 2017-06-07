package com.disney.studios.repository;

import com.disney.studios.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
public interface UserRepository extends CrudRepository<User,Long>{
}
