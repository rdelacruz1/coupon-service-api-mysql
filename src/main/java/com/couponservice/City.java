package com.couponservice;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City {
    @OneToMany(fetch = FetchType.LAZY, mappedBy="city")
    private Set<Coupon> coupons;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long cityLocationId;

    private String cityName;

    private String regionName;

    private String stateName;

    private String countryName;

    public Long getcityId() {
        return cityLocationId;
    }

    public void setCityId(Long cityId) {
        this.cityLocationId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSateName() {
        return stateName;
    }

    public void setStateName() {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName() {
        this.countryName = countryName;
    }
}