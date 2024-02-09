package com.samih.kodluyoruzspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BeanDto {
    
    private Long id;
    private String beanName;
    private String beanData;


    // başlangıç
    public void initialBeanMethod(){
        log.info("Bean başlamadan önce çalışan method.");
        System.out.println("Bean başlamadan önce çalışan method.");
    }


    // bitiş
    public void destroyBeanMethod(){
        log.info("Bean bittikten sonra çalışan method.");
        System.err.println("Bean bittikten sonra çalışan method.");
    }
}
