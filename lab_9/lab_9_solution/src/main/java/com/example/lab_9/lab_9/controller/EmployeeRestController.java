package com.example.lab_9.lab_9.controller;

import com.example.lab_9.lab_9.domain.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class EmployeeRestController {
//    @CrossOrigin(origins = { "http://localhost:8080"},maxAge = 6000)
    @PostMapping(value = "/rest/addEmployee",produces = "application/json")
    public Employee addEmployee(@Valid @RequestBody Employee employee)
    {
        return employee;
    }
}
