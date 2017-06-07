package com.disney.studios.service;

import com.disney.studios.domain.User;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */

public interface UserService {
    public User save(User user);

    public User findOne(long id);
}
