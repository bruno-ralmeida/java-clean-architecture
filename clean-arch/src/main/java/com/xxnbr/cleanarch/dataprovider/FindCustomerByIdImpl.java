package com.xxnbr.cleanarch.dataprovider;

import com.xxnbr.cleanarch.core.dataprovider.FindCustomerById;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.dataprovider.repository.CustomerRepository;
import com.xxnbr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> optionalCustomerEntity = repository.findById(id);

        var customer = new Customer();

        if(optionalCustomerEntity.isEmpty())return Optional.empty();

        BeanUtils.copyProperties(optionalCustomerEntity.get(), customer);

        return Optional.of(customer);

    }
}
