package com.xxnbr.cleanarch.dataprovider;

import com.xxnbr.cleanarch.core.dataprovider.FindCustomerById;
import com.xxnbr.cleanarch.core.domain.Address;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.dataprovider.repository.CustomerRepository;
import com.xxnbr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindCustomerByIdImpl implements FindCustomerById {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> optionalCustomerEntity = repository.findById(id);

        var customer = new Customer();
        var address = new Address();

        if (optionalCustomerEntity.isEmpty()) return Optional.empty();

        BeanUtils.copyProperties(optionalCustomerEntity.get(), customer);
        BeanUtils.copyProperties(optionalCustomerEntity.get().getAddress(), address);
        customer.setAddress(address);

        return Optional.of(customer);

    }
}
