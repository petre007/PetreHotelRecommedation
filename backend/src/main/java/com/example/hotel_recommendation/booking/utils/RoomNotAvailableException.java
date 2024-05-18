package com.example.hotel_recommendation.booking.utils;

public class RoomNotAvailableException extends Exception{

    public RoomNotAvailableException(String message) {
        super(message);
    }
}
