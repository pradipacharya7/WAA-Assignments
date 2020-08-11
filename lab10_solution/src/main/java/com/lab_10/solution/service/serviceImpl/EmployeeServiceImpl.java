package com.lab_10.solution.service.serviceImpl;

import com.lab_10.solution.dao.EmployeeDAO;
import com.lab_10.solution.model.Employee;
import com.lab_10.solution.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDao;

    public Optional<Employee> findById(long id)
    {
        return employeeDao.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return  employeeDao.save(employee);

    }
    public List<Employee> findAll()
    {
        return (List<Employee>) employeeDao.findAll();
    }

    @Override
    public void deleteById(long id) {
        employeeDao.deleteById(id);
    }
    public Employee getEmployeeByNumber(long id)
    {
        return employeeDao.getEmployeeByNumber(id);
    }


}
