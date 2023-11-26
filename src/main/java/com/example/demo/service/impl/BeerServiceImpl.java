package com.example.demo.service.impl;


import com.example.demo.service.BeerService;
import com.example.demo.web.model.BeerStyleEnum;
import com.example.demo.web.model.dto.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j // inject logger
public class BeerServiceImpl implements BeerService  {
    @Override
    public BeerDto getBeerById(UUID beerId) {

        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("beerName 1")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        // should we save this beerDto into database, but we get into that later
        return BeerDto.builder()
                .id(UUID.randomUUID())
//                .beerName("Post Beer Request ")
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //TODO impl - would add a real impl to update beer

    }

    @Override
    public void deleteById(UUID beerId) {
   log.debug("deleting a beer...");
    }

}
