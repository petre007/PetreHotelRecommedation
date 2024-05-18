package com.example.hotel_recommendation.security.exception;

public class NoGrantedAuthorityException extends Exception{

    public NoGrantedAuthorityException(String message) {
        super(message);
    }
}
