package com.example.hotel_recommendation.security.config;

public class Utils {

    public static String[] patterns = {

            "/api/auth/login",
            "/api/auth/register",
            "/api/param/**",
            "/api/hotel/**",
            "/api/book/**"
    };


}
