package com.example.demo.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
// lombok regretting all these getters and setter at compile time

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto {

    private UUID id ;
    private String beerName;
    private String beerStyle;
    private Long upc;

}
