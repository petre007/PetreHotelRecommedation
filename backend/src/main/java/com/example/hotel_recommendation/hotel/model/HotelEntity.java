package com.example.hotel_recommendation.hotel.model;

import com.example.hotel_recommendation.review.model.ReviewEntity;
import com.example.hotel_recommendation.room.model.RoomEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToMany
    @JoinColumn(name = "hotel_id")
    private Set<RoomEntity> roomEntities = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "hotel_id")
    private Set<ReviewEntity> reviewEntities = new HashSet<>();
}
