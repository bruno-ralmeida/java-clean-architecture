package com.xxnbr.cleanarch.entrypoint.consumer;

import com.xxnbr.cleanarch.core.domain.Customer;
import com.xxnbr.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.xxnbr.cleanarch.entrypoint.consumer.message.CustomerMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @KafkaListener(groupId = "xxnbr", topics = "tp-cpf-validated")
    public void receive(CustomerMessage message) {
        var costumer = new Customer();
        BeanUtils.copyProperties(message, costumer);

        log.info("VALIDATED CUSTOMER = {}", costumer.toString());
        updateCustomerUseCase.update(costumer, message.getZipCode());
    }
}
