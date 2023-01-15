package com.xxnbr.cleanarch.core.usecase;

import com.xxnbr.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
