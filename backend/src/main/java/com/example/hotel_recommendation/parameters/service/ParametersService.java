package com.example.hotel_recommendation.parameters.service;

import com.example.hotel_recommendation.parameters.model.ParametersEntity;
import com.example.hotel_recommendation.parameters.repository.ParametersRepository;
import com.example.hotel_recommendation.parameters.utils.Utils;
import com.example.hotel_recommendation.security.config.JwtService;
import com.example.hotel_recommendation.security.exception.NoGrantedAuthorityException;
import com.example.hotel_recommendation.user.model.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParametersService {

    private final ParametersRepository parametersRepository;
    private final JwtService jwtService;

    public List<ParametersEntity> getAll(String token)
            throws NoGrantedAuthorityException {
        this.jwtService.checkRole(token, Roles.ROLE_CLIENT);
        return this.parametersRepository.findAll();
    }

    @Transactional
    public void updateParameterValue(String token ,ParametersEntity parametersEntity)
            throws NoGrantedAuthorityException, IllegalArgumentException {
        this.jwtService.checkRole(token, Roles.ROLE_CLIENT);
        if (Utils.validateDoubleValue(parametersEntity.getValue())) {
            this.parametersRepository.save(parametersEntity);
        }
    }

}
