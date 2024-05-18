package com.example.hotel_recommendation.user.service;

import com.example.hotel_recommendation.security.config.JwtService;
import com.example.hotel_recommendation.user.controller.AuthenticationRequest;
import com.example.hotel_recommendation.user.controller.AuthenticationResponse;
import com.example.hotel_recommendation.user.controller.RegisterRequest;
import com.example.hotel_recommendation.user.model.UserModel;
import com.example.hotel_recommendation.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest register) {
        UserModel userModel = UserModel.builder()
                .username(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(register.getRoles())
                .build();

        userRepository.save(userModel);
        var jwtToken = jwtService.generateToken(userModel);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse login(AuthenticationRequest auth) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));

        var userModel = userRepository.findUserModelByUsername(auth.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(userModel);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .roles(userModel.getRole())
                .build();
    }
}
