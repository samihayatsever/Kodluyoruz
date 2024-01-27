package com.samih.kodluyoruzspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeanDto {
    
    private Long id;
    private String beanName;
    private String beanData;
}
