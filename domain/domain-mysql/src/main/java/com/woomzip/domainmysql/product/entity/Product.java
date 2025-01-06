package com.woomzip.domainmysql.product.entity;

import com.woomzip.domainmysql.auditing.BaseTimeEntity;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;  // 제품 이름

    @Column(name = "price", nullable = false)
    private int price;  // 가격

    @Column(name = "bedroom", nullable = false)
    private int bedroom;  // 침실 개수

    @Column(name = "bathroom", nullable = false)
    private Integer bathroom;  // 욕실 개수

    @Column(name = "real_usable_area", nullable = false)
    private Double realUsableArea;  // 실사용 평수 (소수점 한 자리까지 입력 가능)

    @Column(name = "building_area", nullable = false)
    private Double buildingArea;  // 건축 면적 (소수점 한 자리까지 입력 가능)

    @Column(name = "warranty_period", nullable = false)
    private int warrantyPeriod;  // AS 보증기간

    @Column(name = "special_feature", length = 1000)
    private String specialFeature;  // 제품 특이사항

    @Column(name = "structure_material", length = 1000)
    private String structureMaterial;  // 구조자재

    @Column(name = "wall_material", length = 1000)
    private String wallMaterial;  // 벽체자재

    @Column(name = "insulation_material", length = 1000)
    private String insulationMaterial;  // 단열자재

    @Column(name = "heating_method", length = 1000)
    private String heatingMethod;  // 난방방법

    @Column(name = "interior_material", length = 1000)
    private String interiorMaterial;  // 내장자재

    @Column(name = "window_material", length = 1000)
    private String windowMaterial;  // 창호자재

    @Column(name = "exterior_material", length = 1000)
    private String exteriorMaterial;  // 외장자재

    @Column(name = "roof_material", length = 1000)
    private String roofMaterial;  // 지붕자재

    @Column(name = "kitchen_material", length = 1000)
    private String kitchenMaterial;  // 주방자재

    @Column(name = "bathroom_material", length = 1000)
    private String bathroomMaterial;  // 욕실자재

    @Column(name = "lighting_material", length = 1000)
    private String lightingMaterial;  // 조명자재

    @Column(name = "included_furniture", length = 1000)
    private String includedFurniture;  // 포함가구

    @Column(name = "other_detail", length = 1000)
    private String otherDetail;  // 기타사항

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;  // 디자인 및 제작사

    @Column(name = "price_includes", length = 1000)
    private String priceIncludes;  // 가격에 포함된 사항

    @Builder
    public Product(String productName, int price, int bedroom, Integer bathroom, Double realUsableArea, Double buildingArea, int warrantyPeriod, String specialFeature, String structureMaterial, String wallMaterial, String insulationMaterial, String heatingMethod, String interiorMaterial, String windowMaterial, String exteriorMaterial, String roofMaterial, String kitchenMaterial, String bathroomMaterial, String lightingMaterial, String includedFurniture, String otherDetail, Vendor vendor, String priceIncludes) {
        this.productName = productName;
        this.price = price;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.realUsableArea = realUsableArea;
        this.buildingArea = buildingArea;
        this.warrantyPeriod = warrantyPeriod;
        this.specialFeature = specialFeature;
        this.structureMaterial = structureMaterial;
        this.wallMaterial = wallMaterial;
        this.insulationMaterial = insulationMaterial;
        this.heatingMethod = heatingMethod;
        this.interiorMaterial = interiorMaterial;
        this.windowMaterial = windowMaterial;
        this.exteriorMaterial = exteriorMaterial;
        this.roofMaterial = roofMaterial;
        this.kitchenMaterial = kitchenMaterial;
        this.bathroomMaterial = bathroomMaterial;
        this.lightingMaterial = lightingMaterial;
        this.includedFurniture = includedFurniture;
        this.otherDetail = otherDetail;
        this.vendor = vendor;
        this.priceIncludes = priceIncludes;
    }
}
