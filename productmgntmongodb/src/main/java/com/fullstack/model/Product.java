package com.fullstack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {

    @Id
    private Long productId;

    private String productName;

    private double productPrice;

    private String productDescription;

    private LocalDate productLaunchDate;


}
