package com.xxnbr.cleanarch.core.usecase.impl;

import com.xxnbr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.xxnbr.cleanarch.core.dataprovider.InsertCustomer;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.core.usecase.InsertCustomerUsecase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUsecase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        insertCustomer.insert(customer);
    }
}
