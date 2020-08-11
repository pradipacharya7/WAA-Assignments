package com.lab_10.solution.dao;

import com.lab_10.solution.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeDAO extends CrudRepository<Employee,Long>{

    @Query(value = "SELECT * FROM  Employee e INNER JOIN Address a on a.id = e.address_id where e.id=:id", nativeQuery=true)
    public Employee getEmployeeByNumber(long id);
}
