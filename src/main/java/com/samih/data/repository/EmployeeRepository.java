package com.samih.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samih.data.entity.EmployeeEntity;


// JpaRepository > CrudRepository

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
    
}
