package com.lab_10.solution.service.serviceImpl;

import com.lab_10.solution.dao.AddressDAO;
import com.lab_10.solution.model.Address;
import com.lab_10.solution.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDAO addressDAO;
    public Address save(Address address) {
       return addressDAO.save(address);
    }
}
