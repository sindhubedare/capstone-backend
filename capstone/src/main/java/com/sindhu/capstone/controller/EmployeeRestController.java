package com.sindhu.capstone.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.capstone.exception.ResourceNotFoundException;
import com.sindhu.capstone.model.Employee;
import com.sindhu.capstone.repository.EmployeeRepository;

@RestController
@RequestMapping("/sindhu_api/v1")
public class EmployeeRestController {
	@Autowired
    private EmployeeRepository employeeRepository;

 // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(Model model) {
     	
    return this.employeeRepository.findAll();
   }
   // get employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
      throws ResourceNotFoundException {
      Employee employee = employeeRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
      return ResponseEntity.ok().body(employee);
    }
   // save employee
    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
   	 return employeeRepository.save(employee);
    }
}
