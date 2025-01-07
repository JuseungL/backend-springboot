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

    /**
     * 단순 문의 파트
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name; // 문의자명

    @Column(name = "additional_request", nullable = true, columnDefinition = "TEXT")
    private String additionalRequest; // 문의내용

    @Column(name = "contact", nullable = false, length = 50)
    private String contact; // 연락처

    @Column(name = "response_type", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private ResponseType responseType; // 응답 방식

    /**
     * 심화된 문의 파트
     */
    @JoinColumn(name = "fk_product_id", nullable = true)
    private Long productId; // 제품 ID

    @Column(name = "purpose", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Purpose purpose; // 체류형쉼터 및 농막 or 주택

    @Column(name = "location", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Location location; // 위치(어디에 지을건지)

    @Column(name = "is_land_owner", nullable = false)
    private boolean isLandOwner; // 토지가 있는지

    @Column(name = "budget", nullable = false)
    private int budget; // 예산

    @Column(name = "land_area", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private LandArea landArea; // 토지 면적

    @Column(name = "land_slope", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private LandSlope landSlope; // 토지 경사도

    @Column(name = "land_access", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private LandAccess landAccess; // 토지 진입로

    /**
     * 관심도 파트
     */
    @Column(name = "help_type", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private HelpType helpType; // 어떤 도움 필요?

    @Column(name = "start_plan", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private StartPlan startPlan; // 언제 시작?

    @Column(name = "priority", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Priority priority; // 건축에서 중요 요소

    @Builder
    public Inquiry(String name, String additionalRequest, String contact, ResponseType responseType, Long productId, Purpose purpose, Location location, boolean isLandOwner, int budget, LandArea landArea, LandSlope landSlope, LandAccess landAccess, HelpType helpType, StartPlan startPlan, Priority priority) {
        this.name = name;
        this.additionalRequest = additionalRequest;
        this.contact = contact;
        this.responseType = responseType;
        this.productId = productId;
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
