package com.samih.ui.rest;

import org.springframework.web.bind.annotation.RestController;

import com.samih.business.service.EmployeeServices;

//import org.hibernate.mapping.List;
import com.samih.business.dto.EmployeeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    
    @Autowired
    EmployeeServices employeeServices;
    

    // List
    // http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeServices.getAllEmployees();
        return employeeDtoList;
    }


    // Find
    // http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
            List<EmployeeDto> employeeDtoList = employeeServices.getAllEmployees();
            return ResponseEntity.ok(employeeDtoList.get(0));
    }

    // Save
    // http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
            employeeServices.createEmployee(employeeDto);
            return employeeDto;
    }


    // Update
    // http://localhost:8080/api/v1/employees/1
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) throws Throwable{
            employeeServices.updateEmployee(id, employeeDto);
            return ResponseEntity.ok(employeeDto);
    }


    // Delete
    // http://localhost:8080/api/v1/employees/1
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable{
            employeeServices.deleteEmployee(id);
            Map<String,Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
    }

}
