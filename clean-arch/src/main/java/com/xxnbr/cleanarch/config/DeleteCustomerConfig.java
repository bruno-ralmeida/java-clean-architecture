package com.xxnbr.cleanarch.config;

import com.xxnbr.cleanarch.core.dataprovider.DeleteCustomerById;
import com.xxnbr.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.xxnbr.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomerById deleteCustomerById){
        return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, deleteCustomerById);
    }
}
