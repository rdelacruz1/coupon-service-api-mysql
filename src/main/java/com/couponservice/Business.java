package com.couponservice;

import javax.persistence.*;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long businessId;

    private String businessName;

    public Long getBusinessId() {
        return businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}