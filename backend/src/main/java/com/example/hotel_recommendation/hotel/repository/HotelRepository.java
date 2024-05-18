package com.example.hotel_recommendation.hotel.repository;

import com.example.hotel_recommendation.hotel.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
}
