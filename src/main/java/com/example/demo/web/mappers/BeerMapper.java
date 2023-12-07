package com.example.demo.web.mappers;

import com.example.demo.domain.Beer;
import com.example.demo.web.model.dto.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

//@Mapper(uses =  {DateMapper.class})
@Mapper(componentModel = "spring", uses = {DateMapper.class})
//bean BeerMapper but Mapstruct do not generate a spring bean by default
//@Mapper(componentModel = "spring") annotation to your BeerMapper interface.
// This explicitly tells MapStruct to generate Spring components.


public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto dto);
    BeerDto beerToBeerDto(Beer beer);

}
