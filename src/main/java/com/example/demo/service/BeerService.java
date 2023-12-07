package com.example.demo.service;

import com.example.demo.web.model.dto.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {


    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

//    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
BeerDto  updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
