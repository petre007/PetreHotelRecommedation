package com.example.hotel_recommendation.hotel.controller;

import com.example.hotel_recommendation.hotel.model.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddReviewReqBody {

    private String description;
    private Integer id;

}
