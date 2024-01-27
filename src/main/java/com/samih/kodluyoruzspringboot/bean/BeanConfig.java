package com.samih.kodluyoruzspringboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.samih.kodluyoruzspringboot.dto.BeanDto;

@Configuration
public class BeanConfig {
    

    @Bean
    public BeanDto beanDto(){

        return BeanDto
        .builder()
            .id(1L)
            .beanName("Sami")
            .beanData("Hayatsever")
        .build();
    }
}
