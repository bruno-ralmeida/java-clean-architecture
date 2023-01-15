package com.xxnbr.cleanarch.core.usecase.impl;

import com.xxnbr.cleanarch.core.dataprovider.FindCustomerById;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {

        return findCustomerById.find(id).orElseThrow(() -> new RuntimeException("CUSTOMER NOT FOUND"));
    }
}
