package com.example.hotel_recommendation.booking.utils;

import java.util.Date;

public class Utils {

    private final static long CANCELLATION_INTERVAL = 2 * 1000 * 60 * 60;

    public static boolean operationAvailable(Date bookingDate) {
        Date now = new Date();
        return now.getTime() - bookingDate.getTime() < CANCELLATION_INTERVAL;
    }

}
