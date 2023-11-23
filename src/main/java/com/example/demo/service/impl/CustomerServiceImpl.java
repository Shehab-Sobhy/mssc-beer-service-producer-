package com.example.demo.service.impl;

import com.example.demo.service.CustomerService;
import com.example.demo.web.model.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j // inject logger
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Customer Name 1")
                .build();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO CustomerDTO) {
        // should we save this beerDto into database, but we get into that later
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Customer Name Created  ")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerID, CustomerDTO customerDTO) {
        //TODO impl - would add a real impl to update beer
    }


    @Override
    public void deleteById(UUID customerId) {
        log.debug("deleting a customer...");
    }
}
