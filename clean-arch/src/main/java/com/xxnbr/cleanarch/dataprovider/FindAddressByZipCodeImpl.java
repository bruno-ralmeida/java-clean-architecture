package com.xxnbr.cleanarch.dataprovider;

import com.xxnbr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.xxnbr.cleanarch.core.domain.Address;
import com.xxnbr.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient client;

    @Override
    public Address find(String zipCode) {
        var addressResponse = client.find(zipCode);
        var address = new Address();

        BeanUtils.copyProperties(addressResponse, address);

        return address;
    }
}
