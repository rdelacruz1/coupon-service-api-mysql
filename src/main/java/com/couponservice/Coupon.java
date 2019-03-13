package com.couponservice;

import javax.persistence.*;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long couponId;

    private String description;

    private Long businessId;

    private Long cityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId", insertable=false, updatable=false)
    private City city;

    public Long getCouponId() {
        return couponId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getCouponCity() {
        return businessId;
    }

    public void setCity(Long cityId) {
        this.cityId = cityId;
    }
}