package com.samih.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Data
@NoArgsConstructor
@Builder
@Log4j2
@EqualsAndHashCode(callSuper = true) // @data uyarısı için eklendi

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity implements Serializable {
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_name")
    private Long emailId;

    public EmployeeEntity(String firstName, String lastName, Long emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
    
}
