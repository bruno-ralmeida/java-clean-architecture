package com.xxnbr.cleanarch.dataprovider;

import com.xxnbr.cleanarch.core.dataprovider.InsertCustomer;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.dataprovider.repository.CustomerRepository;
import com.xxnbr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void insert(Customer customer) {
        var customerEntity = new CustomerEntity();

        BeanUtils.copyProperties(customer, customerEntity);

        repository.save(customerEntity);
    }
}
