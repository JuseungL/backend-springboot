package com.woomzip.domainmysql.inquiry.entity;

import com.woomzip.domainmysql.auditing.BaseTimeEntity;
import com.woomzip.domainmysql.inquiry.enums.*;
import com.woomzip.domainmysql.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquiry extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "additional_request", columnDefinition = "TEXT")
    private String additionalRequest;

    @Column(name = "contact", nullable = false, length = 50)
    private String contact;

    @Column(name = "response_type", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ResponseType responseType;

    @JoinColumn(name = "fk_product_id", nullable = true)
    private Long productId;

    @Column(name = "product_type", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "purpose", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    @Column(name = "location", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Location location;

    @Column(name = "is_land_owner", nullable = false)
    private boolean isLandOwner;

    @Column(name = "budget", nullable = false)
    private int budget;

    @Column(name = "land_area", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private LandArea landArea;

    @Column(name = "land_slope", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private LandSlope landSlope;

    @Column(name = "land_access", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private LandAccess landAccess;

    @Column(name = "help_type", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private HelpType helpType;

    @Column(name = "start_plan", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private StartPlan startPlan;

    @Column(name = "priority", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Builder
    public Inquiry(String name, String additionalRequest, String contact, ResponseType responseType, Long productId, ProductType productType, Purpose purpose, Location location, boolean isLandOwner, int budget, LandArea landArea, LandSlope landSlope, LandAccess landAccess, HelpType helpType, StartPlan startPlan, Priority priority) {
        this.name = name;
        this.additionalRequest = additionalRequest;
        this.contact = contact;
        this.responseType = responseType;
        this.productId = productId;
        this.productType = productType;
        this.purpose = purpose;
        this.location = location;
        this.isLandOwner = isLandOwner;
        this.budget = budget;
        this.landArea = landArea;
        this.landSlope = landSlope;
        this.landAccess = landAccess;
        this.helpType = helpType;
        this.startPlan = startPlan;
        this.priority = priority;
    }
}
