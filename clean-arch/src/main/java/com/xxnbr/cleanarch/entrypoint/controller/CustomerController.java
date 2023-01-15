package com.xxnbr.cleanarch.entrypoint.controller;

import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.xxnbr.cleanarch.core.usecase.InsertCustomerUsecase;
import com.xxnbr.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.xxnbr.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUsecase insertCustomerUsecase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest request){

        var customer = new Customer();

        BeanUtils.copyProperties(request,customer);

        insertCustomerUsecase.insert(customer, request.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> search(@PathVariable String id){
        Customer customer = findCustomerByIdUseCase.find(id);

        var customerResponse = new CustomerResponse();

        BeanUtils.copyProperties(customer, customerResponse);

        return ResponseEntity.ok(customerResponse);
    }
}
