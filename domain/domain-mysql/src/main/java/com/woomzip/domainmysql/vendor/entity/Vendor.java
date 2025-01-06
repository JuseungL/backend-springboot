package com.woomzip.domainmysql.vendor.entity;

import com.woomzip.domainmysql.auditing.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vendor extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long id;

    @Column(name = "representative_name", nullable = false, length = 100)
    private String representativeName;

    @Column(name = "representative_image_url")
    private String representativeImageUrl;

    @Column(name = "representative_intro", length = 500)
    private String representativeIntro;

    @Column(name = "vendor_name", nullable = false, length = 100)
    private String vendorName;

    @Column(name = "vendor_intro", length = 1000)
    private String vendorIntro;

    @Builder
    public Vendor(String representativeName, String representativeImageUrl, String vendorName, String representativeIntro, String vendorIntro) {
        this.representativeName = representativeName;
        this.representativeImageUrl = representativeImageUrl;
        this.vendorName = vendorName;
        this.representativeIntro = representativeIntro;
        this.vendorIntro = vendorIntro;
    }
}
