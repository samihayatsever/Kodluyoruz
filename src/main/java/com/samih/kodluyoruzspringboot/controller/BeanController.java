package com.samih.kodluyoruzspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samih.kodluyoruzspringboot.bean.BeanConfig;


@Controller
public class BeanController {
    
    @Autowired
    BeanConfig beanConfig;

    // http://localhost:8080/bean/beanDto
    @GetMapping("/bean/beanDto")
    @ResponseBody  // html olmadan direl ekranda göster
    public String getBeanDto(){
        return beanConfig.beanDto() + ".";
    }

}
