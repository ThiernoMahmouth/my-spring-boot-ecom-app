package com.kowlytech.billingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Product
{
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
