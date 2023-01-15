package com.xxnbr.cleanarch.config;

import com.xxnbr.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.xxnbr.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(FindCustomerByIdImpl findCustomerById) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }

}
