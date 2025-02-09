package com.woomzip.domainmysql.vendor.entity;

import com.woomzip.domainmysql.auditing.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  제휴 업체 엔티티
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vendor extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long id;

    @Column(name = "representative_name", nullable = false, length = 20)
    private String representativeName; // 대표 성함

    @Column(name = "representative_image_url", nullable = false, length = 500)
    private String representativeImageUrl; // 대표 이미지

    @Column(name = "representative_intro", length = 500)
    private String representativeIntro; // 대표 소개

    @Column(name = "vendor_name", nullable = false, length = 20)
    private String vendorName; // 업체 이름

    @Column(name = "vendor_intro", nullable = false, length = 500)
    private String vendorIntro; // 업체 설명

    @Builder
    public Vendor(String representativeName, String representativeImageUrl, String vendorName, String representativeIntro, String vendorIntro) {
        this.representativeName = representativeName;
        this.representativeImageUrl = representativeImageUrl;
        this.vendorName = vendorName;
        this.representativeIntro = representativeIntro;
        this.vendorIntro = vendorIntro;
    }
}
