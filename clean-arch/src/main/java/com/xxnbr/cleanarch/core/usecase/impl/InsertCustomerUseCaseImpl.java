package com.xxnbr.cleanarch.core.usecase.impl;

import com.xxnbr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.xxnbr.cleanarch.core.dataprovider.InsertCustomer;
import com.xxnbr.cleanarch.core.dataprovider.SendCpfValidation;
import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.core.usecase.InsertCustomerUsecase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUsecase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    private final SendCpfValidation sendCpfValidation;

    public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer, SendCpfValidation sendCpfValidation) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfValidation = sendCpfValidation;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        sendCpfValidation.send(customer.getCpf());

        insertCustomer.insert(customer);
    }
}
