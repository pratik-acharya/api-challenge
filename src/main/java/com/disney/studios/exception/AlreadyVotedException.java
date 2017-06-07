package com.disney.studios.exception;

/**
 * Created by Pratik Acharya on 6/7/2017.
 */
public class AlreadyVotedException extends Exception {
    public AlreadyVotedException(String message){
        super(message);
    }

    public AlreadyVotedException(String message, Throwable cause){
        super(message,cause);
    }
}

