package com.lab_10.solution.dao;

import com.lab_10.solution.model.Address;
import com.lab_10.solution.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends CrudRepository<Address, Long> {
}
