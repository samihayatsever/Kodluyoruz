package com.samih.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.samih.business.dto.EmployeeDto;
import com.samih.business.service.EmployeeServices;
import com.samih.data.entity.EmployeeEntity;
import com.samih.data.repository.EmployeeRepository;
import com.samih.exception.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Service
public class EmployeeServiceImpl implements EmployeeServices{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;



    // Dto -> frontend ile etkileşime giren kısım
    // Repository -> database işe etkileşime giren kısım
    // Entity -> backend'te kullanılan kısım: sürekli diğer ikisi ile etkileşim halinde ve dönüştürülür halde, çünkü değişiklikleri entity üzerindne yapıyoruz.

    // LIST 
    // http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entities = employeeRepository.findAll();
        //Iterable<?> entities = employeeRepository.findAll();

        for (EmployeeEntity employeeEntity : entities) { //EmployeeEntity employeeEntity : entities   // Object employeeEntity : entities
            EmployeeDto employeeDto = EntityToDto(employeeEntity);
            //EmployeeDto employeeDto = EntityToDto((EmployeeEntity) employeeEntity);
            listDto.add(employeeDto);
        }

        return listDto;

    }


    // SAVE 
    // http://localhost:8080/api/v1/employees/
    @PostMapping("/Employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);

        return employeeDto;
    }


    // FIND By ID 
    // http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id " + id));
        EmployeeDto employeeDto = EntityToDto(employee);

        return ResponseEntity.ok(employeeDto);
    }


    // UPDATE 
    // http://localhost:8080/api/v1/employees/1
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id " + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(employee);
        return ResponseEntity.ok(employeeDto);
    }


    // DELETE 
    // http://localhost:8080/api/v1/employees/1
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id " + id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Model Mapper

    // Entity to Dto Mapper
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    // Dto to Entity Mapper
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
    
}
