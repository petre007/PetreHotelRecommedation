package com.example.hotel_recommendation.hotel.utils;

public class Utils {

    /*
    *  Function used from this website: https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/
    *
    * */
    public static double calculateHaversineDistance(double hotelLatitude, double hotelLongitude,
                                                    double userLatitude, double userLongitude) {
        double deltaLatitude = Math.toRadians(hotelLatitude - userLatitude);
        double deltaLongitude = Math.toRadians(hotelLongitude - userLongitude);

        // convert to radians
        double lat1 = Math.toRadians(hotelLatitude);
        double lat2 = Math.toRadians(userLatitude);

        // apply formulae
        double a = Math.pow(Math.sin(deltaLatitude / 2), 2) +
                Math.pow(Math.sin(deltaLongitude / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }


}
