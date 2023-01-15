package com.xxnbr.cleanarch.core.dataprovider;

import com.xxnbr.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {
    Optional<Customer> find(final String id);
}
