package com.example.hotel_recommendation.user.repository;

import com.example.hotel_recommendation.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findUserModelByUsername(String username);

}
