package com.example.demo.service.impl;


import com.example.demo.domain.Beer;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.BeerService;
import com.example.demo.web.mappers.BeerMapper;
import com.example.demo.web.model.BeerStyleEnum;
import com.example.demo.web.model.dto.BeerDto;
import com.example.demo.web.model.repos.BeerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j // inject logger
public class BeerServiceImpl implements BeerService {

    private final BeerRepo beerRepo;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
//        return BeerDto.builder().id(UUID.randomUUID())
//                .beerName("beerName 1")
//                .beerStyle(BeerStyleEnum.ALE)
//                .build();

        return beerMapper.beerToBeerDto(beerRepo.findById(beerId).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        // should we save this beerDto into database, but we get into that later
//        return BeerDto.builder()
//                .id(UUID.randomUUID())
////                .beerName("Post Beer Request ")
//                .build();

        return beerMapper.beerToBeerDto(beerRepo.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        //TODO impl - would add a real impl to update beer

        Beer beer = beerRepo.findById(beerId).orElseThrow( ()-> new NotFoundException());

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

    return  beerMapper.beerToBeerDto(beerRepo.save(beer));
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("deleting a beer...");
    }

}
