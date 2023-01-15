package com.xxnbr.cleanarch.dataprovider;

import com.xxnbr.cleanarch.core.dataprovider.DeleteCustomerById;
import com.xxnbr.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
