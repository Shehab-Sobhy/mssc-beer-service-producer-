package com.example.demo.web.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPageList extends PageImpl <BeerDto> {

    @JsonCreator
    public BeerPageList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPageList(List<BeerDto> content) {
        super(content);
    }
}
