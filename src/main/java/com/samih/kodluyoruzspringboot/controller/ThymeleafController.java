package com.samih.kodluyoruzspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ThymeleafController {
    
    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody // sayfayı yönlendirmeden direk gönderir.
    public String getThymeleaf1(){
        return "thymeleaf1";
    }
}
