package com.lab_10.solution.service;

import com.lab_10.solution.model.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    public Optional<Employee> findById(long id);

    public Employee save(Employee employee);

    public List<Employee> findAll();

    public void deleteById(long id);

    public Employee getEmployeeByNumber(long id);
}
