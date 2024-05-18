package com.example.hotel_recommendation.user.init;

import com.example.hotel_recommendation.user.controller.RegisterRequest;
import com.example.hotel_recommendation.user.model.Roles;
import com.example.hotel_recommendation.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserInit {

    private final AuthService authService;

    @Bean
    public void init2() {
        this.authService.register(RegisterRequest.builder()
                .username("petre")
                .password("petre")
                .roles(Roles.ROLE_ADMIN)
                .build());
        this.authService.register(RegisterRequest.builder()
                .username("rebeca")
                .password("rebeca")
                .roles(Roles.ROLE_CLIENT)
                .build());
    }

}
