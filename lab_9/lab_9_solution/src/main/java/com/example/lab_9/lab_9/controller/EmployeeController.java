package com.example.lab_9.lab_9.controller;

import com.example.lab_9.lab_9.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EmployeeController {
    @GetMapping("/")
    public String ShowEmployeeForm(@ModelAttribute("employee") Employee employee)
    {
    return "employee";
    }
//    @PostMapping("/addemployee")
//    public String ShowEmployeeForm(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult)
//    {
//        bindingResult.hasErrors();
//        return "employee";
//    }
	
	
}
