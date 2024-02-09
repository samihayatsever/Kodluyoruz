package com.samih.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderBean {

    @Bean
    public PasswordEncoderBean passwordEncoderBean(){
        return new PasswordEncoderBean();
    }
    
}
