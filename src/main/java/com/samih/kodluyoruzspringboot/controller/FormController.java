package com.samih.kodluyoruzspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.samih.kodluyoruzspringboot.dto.TeacherDto;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@Log4j2
public class FormController {
    

    // FORM methods
    // @GetMapping
    // @PostMapping
    // @PutMapping
    // @DeleteMapping


    // GetMethod
    // http://localhost:8080/form
    @GetMapping("/form")
    public String getForm(Model model){

        model.addAttribute("cv_teacher", new TeacherDto());
        return "form_post/formvalidation";
    }


    // PostMethod
    // http://localhost:8080/form
    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher") TeacherDto teacherDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Bir hata var..");
            System.err.println("Bir hata var..");
            return "form_post/formvalidation";
        }
        log.info("Success. " + teacherDto);
        //database kaydetme alanı olabilir

        return "form_post/success";
    }
}
