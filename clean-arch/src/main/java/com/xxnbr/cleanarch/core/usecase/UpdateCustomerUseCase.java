package com.xxnbr.cleanarch.core.usecase;

import com.xxnbr.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zipCode);
}
