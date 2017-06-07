package com.disney.studios.formatter;

import com.disney.studios.domain.Picture;
import com.disney.studios.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Pratik Acharya on 6/7/2017.
 */

@Component
public class PictureFormatter implements Formatter<Picture> {
    @Autowired
    private PictureService pictureService;

    @Override
    public Picture parse(String id, Locale locale) throws ParseException {
        return this.pictureService.findOne(Long.parseLong(id));
    }

    @Override
    public String print(Picture picture, Locale locale) {
        return picture.getUrl();
    }
}
