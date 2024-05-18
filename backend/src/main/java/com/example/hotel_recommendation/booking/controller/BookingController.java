package com.example.hotel_recommendation.booking.controller;

import com.example.hotel_recommendation.booking.model.BookingEntity;
import com.example.hotel_recommendation.booking.service.BookingService;
import com.example.hotel_recommendation.booking.utils.CancelBookingException;
import com.example.hotel_recommendation.booking.utils.RoomNotAvailableException;
import com.example.hotel_recommendation.room.model.RoomEntity;
import com.example.hotel_recommendation.security.exception.NoGrantedAuthorityException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/get_all")
    public ResponseEntity<List<BookingEntity>> getAll() {
        return ResponseEntity.ok(this.bookingService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestHeader String token,
                                                @RequestBody RoomEntity roomEntity)
            throws NoGrantedAuthorityException, RoomNotAvailableException {
        this.bookingService.addBooking(token, roomEntity);
        return ResponseEntity.ok("Room booked");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBooking(@RequestHeader String token,
                                                @RequestBody BookingEntity bookingEntity)
            throws CancelBookingException, NoGrantedAuthorityException {
        this.bookingService.deleteBooking(token, bookingEntity);
        return ResponseEntity.ok("Booking deleted");
    }


}
