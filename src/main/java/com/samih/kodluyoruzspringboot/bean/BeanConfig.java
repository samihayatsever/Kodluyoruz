package com.samih.kodluyoruzspringboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.samih.kodluyoruzspringboot.dto.BeanDto;

@Configuration
public class BeanConfig {
    

    @Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton") // singleton, request, session
    public BeanDto beanDto(){

        return BeanDto
        .builder()
            .id(1L)
            .beanName("Sami")
            .beanData("Hayatsever")
        .build();
    }
}
