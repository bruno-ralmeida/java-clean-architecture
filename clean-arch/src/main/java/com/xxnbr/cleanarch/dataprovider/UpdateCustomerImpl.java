package com.xxnbr.cleanarch.dataprovider;

import com.xxnbr.cleanarch.core.dataprovider.UpdateCustomer;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.dataprovider.repository.CustomerRepository;
import com.xxnbr.cleanarch.dataprovider.repository.entity.AddressEntity;
import com.xxnbr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerImpl implements UpdateCustomer {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void update(Customer customer) {
        var customerEntity = new CustomerEntity();
        var addressEntity = new AddressEntity();

        BeanUtils.copyProperties(customer, customerEntity);
        BeanUtils.copyProperties(customer.getAddress(), addressEntity);

        customerEntity.setAddress(addressEntity);

        repository.save(customerEntity);
    }
}
