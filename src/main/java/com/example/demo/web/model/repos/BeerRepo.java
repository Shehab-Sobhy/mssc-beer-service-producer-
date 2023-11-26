package com.example.demo.web.model.repos;

import com.example.demo.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepo extends PagingAndSortingRepository<Beer , UUID> {
}
