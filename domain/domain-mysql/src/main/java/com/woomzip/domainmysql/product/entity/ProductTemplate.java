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

    @Column(name = "title", nullable = true, length = 50)
    private String title; // 제품 템플릿 제목

    @Column(name = "description", nullable = true, length = 500)
    private String description; // 제품 템플릿 설명

    @Column(name = "product_template_image_url", nullable = true, columnDefinition = "TEXT")
    private String productTemplateImageUrl; // 제품 템플릿 이미지

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // 제품 ID (어느 제품의 템플릿인지 식별)

    @Column(name = "template_type", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private ProductTemplateType productTemplateType; // 제품 템플릿 타입

    @Column(name = "product_template_index", nullable = false)
    private Long index; // 템플릿 렌더링 순서

    @Builder
    public ProductTemplate(String title, String description, String productTemplateImageUrl, Product product, ProductTemplateType productTemplateType, Long index) {
        this.title = title;
        this.description = description;
        this.productTemplateImageUrl = productTemplateImageUrl;
        this.product = product;
        this.productTemplateType = productTemplateType;
        this.index = index;
    }
}
