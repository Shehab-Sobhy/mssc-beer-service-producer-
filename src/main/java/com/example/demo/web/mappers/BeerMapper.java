package com.example.demo.web.mappers;

import com.example.demo.domain.Beer;
import com.example.demo.web.model.dto.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses =  {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerDtoToBeer(Beer beer);
    Beer BeerToBeerDto(BeerDto beerDto);
}
