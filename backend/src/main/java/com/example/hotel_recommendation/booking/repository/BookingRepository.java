package com.example.hotel_recommendation.booking.repository;

import com.example.hotel_recommendation.booking.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
}
