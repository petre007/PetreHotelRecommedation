package com.example.hotel_recommendation.parameters.repository;

import com.example.hotel_recommendation.parameters.model.ParametersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametersRepository extends JpaRepository<ParametersEntity, Integer> {

    ParametersEntity findParametersEntityByName(String name);

}
