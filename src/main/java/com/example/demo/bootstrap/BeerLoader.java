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

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepo beerRepo;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    public void loadBeerObjects() {
        if (beerRepo.count() == 0) {
            beerRepo.save(Beer.builder()
                    .beerName("Mango bobs beer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepo.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_PALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepo.save(Beer.builder()
                    .beerName("No Hammers ")
                    .beerStyle("PALE_PALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepo.count());
    }

}
