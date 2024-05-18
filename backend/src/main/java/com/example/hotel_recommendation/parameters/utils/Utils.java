package com.example.hotel_recommendation.parameters.utils;

public class Utils {

    public static boolean validateDoubleValue(String value) {
        try {
            Double.parseDouble(value);
        }catch (Exception e) {
            throw new IllegalArgumentException("Could not convert from string to double the value "+value);
        }
        return true;
    }


}
