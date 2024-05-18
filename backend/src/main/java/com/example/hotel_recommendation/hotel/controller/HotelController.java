package com.example.hotel_recommendation.hotel.controller;

import com.example.hotel_recommendation.hotel.model.HotelEntity;
import com.example.hotel_recommendation.hotel.service.HotelService;
import com.example.hotel_recommendation.security.exception.NoGrantedAuthorityException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotel")
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    @PostMapping("/hotel_nearby")
    public ResponseEntity<List<HotelEntity>> getHotelNearBy(@RequestHeader String token,
                                                            @RequestBody UserCoordinates userCoordinates)
            throws NoGrantedAuthorityException {
        log.info("Get near by hotels operation");
        return ResponseEntity.ok(this.hotelService.getNearByHotels(token,
                userCoordinates.getLatitude(),
                userCoordinates.getLongitude()));
    }

    @PostMapping("/add_review")
    public ResponseEntity<String> addReview(@RequestHeader String token,
                                            @RequestBody AddReviewReqBody addReviewReqBody)
            throws NoGrantedAuthorityException {
        this.hotelService.addReview(token,
                addReviewReqBody.getDescription(),
                addReviewReqBody.getId());
        return ResponseEntity.ok("Review added");
    }
}
