package com.example.hotel_recommendation.booking.service;

import com.example.hotel_recommendation.booking.model.BookingEntity;
import com.example.hotel_recommendation.booking.repository.BookingRepository;
import com.example.hotel_recommendation.booking.utils.CancelBookingException;
import com.example.hotel_recommendation.booking.utils.RoomNotAvailableException;
import com.example.hotel_recommendation.booking.utils.Utils;
import com.example.hotel_recommendation.room.model.RoomEntity;
import com.example.hotel_recommendation.room.repository.RoomRepository;
import com.example.hotel_recommendation.security.config.JwtService;
import com.example.hotel_recommendation.security.exception.NoGrantedAuthorityException;
import com.example.hotel_recommendation.user.model.Roles;
import com.example.hotel_recommendation.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final JwtService jwtService;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;


    public List<BookingEntity> getAll() {
        return this.bookingRepository.findAll();
    }

    @Transactional
    public void addBooking(String token, RoomEntity roomEntity)
            throws NoGrantedAuthorityException, RoomNotAvailableException {
        this.jwtService.checkRole(token, Roles.ROLE_CLIENT);
        if (roomEntity.getIsAvailable()){
            roomEntity.setIsAvailable(false);
        } else {
            throw new RoomNotAvailableException("Room with id " + roomEntity.getId() + " is not available");
        }

        this.roomRepository.save(roomEntity);
        BookingEntity bookingEntity = BookingEntity.builder()
                .userModel(this.userRepository
                        .findUserModelByUsername(this.jwtService.extractUsername(token))
                        .orElseThrow())
                .roomEntity(roomEntity)
                .date(new Date())
                .build();
        this.bookingRepository.save(bookingEntity);
    }

    @Transactional
    public void deleteBooking(String token, BookingEntity bookingEntity)
            throws NoGrantedAuthorityException, CancelBookingException {
        this.jwtService.checkRole(token, Roles.ROLE_CLIENT);
        if (Utils.operationAvailable(bookingEntity.getDate())) {
            RoomEntity roomEntity = bookingEntity.getRoomEntity();
            roomEntity.setIsAvailable(true);
            this.roomRepository.save(roomEntity);
            this.bookingRepository.delete(bookingEntity);
        }else {
            throw new CancelBookingException("Could not cancel the booking");
        }

    }

}
