package com.xxnbr.cleanarch.entrypoint.controller;

import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.xxnbr.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.xxnbr.cleanarch.core.usecase.InsertCustomerUsecase;
import com.xxnbr.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.xxnbr.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.xxnbr.cleanarch.entrypoint.controller.response.AddressResponse;
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

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest request){

        var customer = new Customer();

        BeanUtils.copyProperties(request,customer);

        insertCustomerUsecase.insert(customer, request.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        Customer customer = findCustomerByIdUseCase.find(id);

        var customerResponse = new CustomerResponse();
        var addressResponse = new AddressResponse();

        BeanUtils.copyProperties(customer, customerResponse);
        BeanUtils.copyProperties(customer.getAddress(), addressResponse);

        customerResponse.setAddressResponse(addressResponse);

        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Void> update(@PathVariable final String id, @RequestBody @Valid CustomerRequest request){
        var customer = new Customer();
        customer.setId(id);
        BeanUtils.copyProperties(request,customer);

        updateCustomerUseCase.update(customer, request.getZipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}
