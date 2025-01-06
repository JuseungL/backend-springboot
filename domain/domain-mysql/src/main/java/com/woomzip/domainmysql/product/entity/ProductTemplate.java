package com.woomzip.domainmysql.product.entity;

import com.woomzip.domainmysql.product.enums.ProductTemplateType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_template_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "product_image_url", nullable = false)
    private String productImageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "template_type", nullable = false)
    private ProductTemplateType productTemplateType;


    @Column(name = "product_template_index", nullable = false)
    private int index;

    @Builder
    public ProductTemplate(String title, String description, String productImageUrl, Product product, ProductTemplateType productTemplateType, int index) {
        this.title = title;
        this.description = description;
        this.productImageUrl = productImageUrl;
        this.product = product;
        this.productTemplateType = productTemplateType;
        this.index = index;
    }
}
