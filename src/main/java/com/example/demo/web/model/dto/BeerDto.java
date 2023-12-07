package com.example.demo.web.model.dto;

import com.example.demo.web.model.BeerStyleEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
// lombok regretting all these getters and setter at compile time

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto {



//    @Null
//    private UUID id;
//
//    @NotBlank //field must not be the empty string
//    private String beerName;
//
//    @NotBlank //field must not be the empty string
//    private String beerStyle;
//
//    @Positive
//    private Long upc;
//


//   so now when this pojo is being bound we are saying this must be null so
//     we wont somebody to set this property's from this outside word
    // if somebody does try to set them is gonna fail our validation
     @Null
    UUID id;
    @Null
    Integer version;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T':HH:mm:ssZ" , shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createData;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T':HH:mm:ssZ" , shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;



    @NotBlank
    String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;


    @NotNull
    @Positive
    private String upc;



 @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Positive
    private BigDecimal price;

   private Integer minOnHand;  // minimum quantity on hand

    private Integer quantityToBrew;


}
