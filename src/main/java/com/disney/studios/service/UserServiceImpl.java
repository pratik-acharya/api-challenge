package com.disney.studios.service;

import com.disney.studios.domain.User;
import com.disney.studios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pratik Acharya on 6/6/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findOne(long id) {
        return this.userRepository.findOne(id);
    }
}
