package com.xxnbr.cleanarch.config;

import com.xxnbr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.xxnbr.cleanarch.core.dataprovider.UpdateCustomer;
import com.xxnbr.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.xxnbr.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomer(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer) {
        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
    }
}
