package com.samih.kodluyoruzspringboot.bean;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class PostContructTutorials {
    
    @Autowired
    Logger LOG;

    
    /* Bu Hata veriyor; Autowired yapısı(bean) henüz başlamadığından null hatası alıyoruz. Bağımlılığı inject edemiyoruz.
    public PostContructTutorials() {
        LOG.info("Log info çağırıldı.");
    }
    */

    @PostConstruct // Construct, bir bean nesnesi oluşturulduğunda hemen oluşur.
    public void init(){
        LOG.info("log info çağırıldı!!");
    }


    public static void main(String[] args) {
        PostContructTutorials postContructTutorials = new PostContructTutorials();
        System.out.println(postContructTutorials);
    }
}
