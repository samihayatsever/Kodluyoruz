package com.samih.kodluyoruzspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.samih.kodluyoruzspringboot.dto.ProductDto;

@Controller
public class ThymeleafController {

    @GetMapping({"/", "index"}) // Opsiyonel mapping, root ya da index yazarak saygfaya erişebiliriz.
    public String index(){
        return "index";
    }







    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    // @ResponseBody // sayfayı yönlendirmeden direk gönderir.
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Modelden Gelen Veri 1"); // Alt + Shif + up/down (copy a line up or down)
        model.addAttribute("key_model2", "Modelden Gelen Veri 2");
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Modelden Gelen Veri 1");
        model.addAttribute("key_model2", "Modelden Gelen Veri 2");
        return "test_file/thymeleaf3";
    }

    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Modelden Gelen Veri 4");
        return "/thymeleaf4";
    }

    ///////////////////////////////////////
    // Model object gönderme
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5Model(Model model) {
        model.addAttribute("key_model1", "text");
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productPrice(2500)
                .build();

        model.addAttribute("key_model2", productDto);
        return "/thymeleaf5";
    }

    // Model object list gönderme
    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6Model(Model model) {
        model.addAttribute("key_model1", "text");

        List<ProductDto> listProduct = new ArrayList<>();

        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı1")
                .productPrice(1500)
                .build();

        listProduct.add(productDto);

        listProduct.add(ProductDto
                .builder()
                .productId(2L)
                .productName("Ürün Adı2")
                .productPrice(2500)
                .build());

        listProduct.add(ProductDto
                .builder()
                .productId(3L)
                .productName("Ürün Adı3")
                .productPrice(3500)
                .build());

        listProduct.add(ProductDto
                .builder()
                .productId(4L)
                .productName("Ürün Adı4")
                .productPrice(4500)
                .build());

        model.addAttribute("productList", listProduct);
        return "/thymeleaf6";
    }


    // Model object gönderme
    // http://localhost:8080/thymeleaf7/4
    @GetMapping({"/thymeleaf7/{id}", "/thymeleaf7", "/thymeleaf7/"})
    public String getThymeleaf7Model(Model model, @PathVariable(name ="id", required = false) Long id) {
        if(id != null){
            model.addAttribute("key_model1", "id: " + id);
        }else {
            model.addAttribute("key_model1", "id girişi yapılmadı.");
        }
        
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productPrice(2500)
                .build();

        model.addAttribute("key_model2", productDto);
        return "/thymeleaf7";
    }

}
