package com.example.hotel_recommendation.hotel.service;

import com.example.hotel_recommendation.hotel.model.HotelEntity;
import com.example.hotel_recommendation.hotel.repository.HotelRepository;
import com.example.hotel_recommendation.hotel.utils.Utils;
import com.example.hotel_recommendation.parameters.repository.ParametersRepository;
import com.example.hotel_recommendation.review.model.ReviewEntity;
import com.example.hotel_recommendation.review.repository.ReviewRepository;
import com.example.hotel_recommendation.security.config.JwtService;
import com.example.hotel_recommendation.security.exception.NoGrantedAuthorityException;
import com.example.hotel_recommendation.user.model.Roles;
import com.example.hotel_recommendation.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final ParametersRepository parametersRepository;
    private final ReviewRepository reviewRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;


    public List<HotelEntity> getNearByHotels(String token, Double userLatitude, Double userLongitude)
            throws NoGrantedAuthorityException {
        this.jwtService.checkRole(token, Roles.ROLE_CLIENT);

        double radius = Double.parseDouble(this.parametersRepository.findParametersEntityByName("radius").getValue());

        return this.hotelRepository.findAll().
                stream()
                .filter(hotelEntity ->
                        Utils.calculateHaversineDistance(hotelEntity.getLatitude(),
                                hotelEntity.getLongitude(),
                                userLatitude,
                                userLongitude) < radius)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addReview(String token, String description, Integer id)
            throws NoGrantedAuthorityException {
        this.jwtService.checkRole(token, Roles.ROLE_CLIENT);
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .user(this.userRepository.findUserModelByUsername(this.jwtService.extractUsername(token))
                        .orElseThrow())
                .description(description)
                .build();
        this.reviewRepository.save(reviewEntity);
        HotelEntity hotelEntity = this.hotelRepository.getReferenceById(id);
        hotelEntity.getReviewEntities().add(reviewEntity);
        this.hotelRepository.save(hotelEntity);
    }
}


