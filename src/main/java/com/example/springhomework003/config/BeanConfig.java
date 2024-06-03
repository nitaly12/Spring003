package com.example.springhomework003.config;

import com.example.springhomework003.model.dto.response.VenueResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
