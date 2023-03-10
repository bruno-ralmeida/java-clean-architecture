package com.xxnbr.cleanarch.config;

import com.xxnbr.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.xxnbr.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.xxnbr.cleanarch.dataprovider.InsertCustomerImpl;
import com.xxnbr.cleanarch.dataprovider.SendCpfValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUsecase(FindAddressByZipCodeImpl findAddressByZipCode, InsertCustomerImpl insertCustomer, SendCpfValidationImpl sendCpfValidation) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer,sendCpfValidation);
    }

}
