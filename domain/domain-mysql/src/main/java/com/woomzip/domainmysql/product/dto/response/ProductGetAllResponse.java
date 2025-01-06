package com.woomzip.domainmysql.product.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductGetAllResponse {
    private Long id;                 // Product ID
    private String productName;      // Product Name
    private Double realUsableArea;   // Real Usable Area
    private int bedroom;             // Number of Bedrooms
    private Integer bathroom;        // Number of Bathrooms
    private int price;               // Price
    private String productImageUrl;  // Product Image URL (if required)
}