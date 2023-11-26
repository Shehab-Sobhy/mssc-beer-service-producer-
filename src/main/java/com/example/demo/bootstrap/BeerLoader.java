package com.example.demo.bootstrap;

//bootstrap class to initialize beer object

import com.example.demo.domain.Beer;
import com.example.demo.web.model.repos.BeerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// class is gonna run on startup

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepo beerRepo;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepo.count() == 0) {
            beerRepo.save(Beer.builder()
                    .beerName("Mango bobs beer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepo.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_PALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000002L)
                    .price(new BigDecimal("12.95"))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepo.count());
    }

}
