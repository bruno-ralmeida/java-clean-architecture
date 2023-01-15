package com.xxnbr.cleanarch.dataprovider.repository;

import com.xxnbr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
