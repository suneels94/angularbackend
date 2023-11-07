package com.ProjectSuneel.BackendServer.controller;

import com.ProjectSuneel.BackendServer.exception.ResourceNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ProjectSuneel.BackendServer.employeeRepository;
import com.ProjectSuneel.BackendServer.model.employee;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")

public class employeecotroller {
    @Autowired
    private employeeRepository EmployeeRepo;

    //Get List of employees
    @GetMapping("/employeesList")
    public List<employee> getAllEmployees(){
        return EmployeeRepo.findAll();
    }

    // Create Employee RestAPI
    @PostMapping("/createEmployee")
    public employee createEmployee(@RequestBody employee Employee){
        return EmployeeRepo.save(Employee);
    }

    // Getting employee based on id
    @GetMapping("/employee/{id}")
    public ResponseEntity<employee> getemployeeById(@PathVariable long id){
        employee Employee = EmployeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotfoundException("Employee doesnt exists"+ id));
        return ResponseEntity.ok(Employee);
    }

    // update Employee Rest API
    @PutMapping("/employee/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable long id, @RequestBody employee EmployeeDetails){
        employee Employee = EmployeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotfoundException("Employee doesnt exists"+ id));
        Employee.setEmail(EmployeeDetails.getEmail());
        Employee.setFirstname(EmployeeDetails.getFirstname());
        Employee.setPhone(EmployeeDetails.getPhone());
        Employee.setLastname(EmployeeDetails.getLastname());
        Employee.setPassword(EmployeeDetails.getPassword());
        Employee.setUsername(EmployeeDetails.getUsername());

        employee updateEmployee = EmployeeRepo.save(Employee);
        return ResponseEntity.ok(updateEmployee);
    }
}
