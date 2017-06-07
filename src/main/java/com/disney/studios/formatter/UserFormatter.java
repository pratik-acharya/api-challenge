package com.disney.studios.formatter;

import com.disney.studios.domain.User;
import com.disney.studios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


/**
 * Created by Pratik Acharya on 6/7/2017.
 */
@Component
public class UserFormatter implements Formatter<User>{
    @Autowired
    private UserService userService;

    @Override
    public User parse(String id, Locale locale) throws ParseException {
        return this.userService.findOne(Long.parseLong(id));
    }

    @Override
    public String print(User user, Locale locale) {
        return user.getUsername();
    }
}
