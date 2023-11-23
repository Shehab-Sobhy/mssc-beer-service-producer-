package com.example.demo.service;

import com.example.demo.web.model.dto.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
    CustomerDTO saveCustomer(CustomerDTO CustomerDTO);

    void updateCustomer(UUID customerID, CustomerDTO customerDTO);

    void deleteById(UUID customerId);
}
