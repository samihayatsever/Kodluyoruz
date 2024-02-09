package com.samih.dto;
//Data Transfer Object

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class Employeeentity {

    private Long emloyeeId;
    private String firstName;
    private String lastName;
    private Long emailId;
}
