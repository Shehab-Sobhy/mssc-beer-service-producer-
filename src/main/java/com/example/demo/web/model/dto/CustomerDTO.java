package com.example.demo.web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private UUID id;
    private String name;

}
