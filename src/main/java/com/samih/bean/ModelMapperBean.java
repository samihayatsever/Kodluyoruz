package com.samih.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
    
    @Bean
    public ModelMapperBean modelMapperBean(){
        return new ModelMapperBean();
    }
}
