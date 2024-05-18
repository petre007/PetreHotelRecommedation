package com.example.hotel_recommendation.parameters.init;

import com.example.hotel_recommendation.parameters.model.ParametersEntity;
import com.example.hotel_recommendation.parameters.repository.ParametersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParamInit {

    private final ParametersRepository parametersRepository;

    @Bean
    public void initParameters() {
        this.parametersRepository.save(ParametersEntity.builder()
                .name("radius")
                .description("Radius in which you want to find the nearby hotels")
                .value("100")
                .build());
    }

}
