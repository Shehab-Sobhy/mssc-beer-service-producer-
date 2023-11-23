package com.example.demo.web.controller;


import com.example.demo.service.CustomerService;
import com.example.demo.web.model.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    @PostMapping("")
    public ResponseEntity handleCustomerPost(@RequestBody CustomerDTO CustomerDTO) {
        // instead of returning the response req
        //return ResponseEntity.ok(beerService.saveNewBeer(beerDto));
        CustomerDTO saveCustomerDto = service.saveCustomer(CustomerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", " /api/v1/beer/customer/" + saveCustomerDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleCustomerUpdate(@PathVariable UUID customerId, @RequestBody CustomerDTO customerDTO) {
        return new  ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID customerId) {
        service.deleteById(customerId);


    }
}
