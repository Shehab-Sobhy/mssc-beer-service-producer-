package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

// jpa entity for beer object
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID") //hibernate automatically generate uuid for us
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    //particulars about colum for storing uuid
    @Column(length = 36 , columnDefinition = "varchar" , updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    //hibernate extension to jpa
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    private String beerName;
    private String beerStyle;

    @Column(unique = true)
    private Long upc;


    private BigDecimal price;

    private Integer minOnHand;  // minimum quantity on hand
    private Integer quantityToBrew;

}
