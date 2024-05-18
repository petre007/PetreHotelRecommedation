package com.example.hotel_recommendation.hotel.init;

import com.example.hotel_recommendation.hotel.model.HotelEntity;
import com.example.hotel_recommendation.hotel.repository.HotelRepository;
import com.example.hotel_recommendation.room.model.RoomEntity;
import com.example.hotel_recommendation.room.model.Type;
import com.example.hotel_recommendation.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class HotelInit {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Bean
    public void initHotels() {

        Set<RoomEntity> set1 = Set.of(
                RoomEntity.builder()
                        .roomNumber(210)
                        .type(Type.DOUBLE_ROOM)
                        .price(200.0)
                        .isAvailable(true)
                        .build(),
                RoomEntity.builder()
                        .roomNumber(125)
                        .type(Type.SINGLE_ROOM)
                        .price(350.0)
                        .isAvailable(true)
                        .build(),
                RoomEntity.builder()
                        .roomNumber(87)
                        .type(Type.SINGLE_ROOM)
                        .price(300.0)
                        .isAvailable(false)
                        .build()
        );
        Set<RoomEntity> set2 = Set.of(
                RoomEntity.builder()
                        .roomNumber(41)
                        .type(Type.MATRIMONIAL_ROOM)
                        .price(240.0)
                        .isAvailable(true)
                        .build()
        );
        Set<RoomEntity> set3 = Set.of(
                RoomEntity.builder()
                        .roomNumber(31)
                        .type(Type.DOUBLE_ROOM)
                        .price(410.0)
                        .isAvailable(false)
                        .build(),
                RoomEntity.builder()
                        .roomNumber(21)
                        .type(Type.DOUBLE_ROOM)
                        .price(350.0)
                        .isAvailable(true)
                        .build(),
                RoomEntity.builder()
                        .roomNumber(64)
                        .type(Type.MATRIMONIAL_ROOM)
                        .price(300.0)
                        .isAvailable(true)
                        .build()
        );
        this.roomRepository.saveAll(set1);
        this.roomRepository.saveAll(set2);
        this.roomRepository.saveAll(set3);
        this.hotelRepository.save(HotelEntity.builder()
                .name("Hotel Ramada")
                .latitude(46.764654252624204)
                .longitude(23.598674125224626)
                .roomEntities(set1)
                .build());
        this.hotelRepository.save(HotelEntity.builder()
                .name("Grand Hotel Italia")
                .latitude(46.7522792440665)
                .longitude(23.605990381045697)
                .roomEntities(set2)
                .build());
        this.hotelRepository.save(HotelEntity.builder()
                .name("Hampton by Hilton")
                .latitude(46.77539900854998)
                .longitude(23.60182699638966)
                .roomEntities(set3)
                .build());

    }


}
