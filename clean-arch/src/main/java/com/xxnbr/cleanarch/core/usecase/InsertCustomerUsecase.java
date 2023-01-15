package com.xxnbr.cleanarch.core.usecase;

import com.xxnbr.cleanarch.core.domain.Customer;

public interface InsertCustomerUsecase {
    void insert(Customer customer, String zipCode);
}
