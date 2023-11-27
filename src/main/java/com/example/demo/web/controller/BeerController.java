package com.example.demo.web.controller;

import com.example.demo.service.BeerService;
import com.example.demo.web.model.dto.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class  BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {

        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }


    @PostMapping("")
    public ResponseEntity handlePost( @RequestBody BeerDto beerDto) {
        // instead of returning the response req
        //return ResponseEntity.ok(beerService.saveNewBeer(beerDto));
        BeerDto saveDto = beerService.saveNewBeer(beerDto);

        // we are gonna return location header on it
        // TODO add hostname to url
         HttpHeaders   headers = new HttpHeaders();
//        beerDto.getId().toString()
        headers.add("Location","/api/v1/beer/" + UUID.randomUUID() );
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate (@PathVariable UUID beerId , @Valid @RequestBody BeerDto beerDto){
    beerService.updateBeer(beerId , beerDto);

    return new  ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer (@PathVariable UUID beerId){
    beerService.deleteById(beerId);

    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
//
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
//        });
//
//        return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);
//    }
}
