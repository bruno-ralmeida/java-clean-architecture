package com.xxnbr.cleanarch.core.dataprovider;

import com.xxnbr.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);
}
