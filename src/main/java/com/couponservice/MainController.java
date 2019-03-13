package com.couponservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private CouponRepository couponRepository;

    @GetMapping(path="/addBusiness")
    public @ResponseBody String addBusiness(@RequestParam String businessName) {
        Business business = new Business();
        business.setBusinessName(businessName);
        businessRepository.save(business);
        return "Business added";
    }

    @GetMapping(path="/issueCoupon")
    public @ResponseBody String issueCoupon (@RequestParam Long businessId,
        @RequestParam String description, @RequestParam Long cityId) {
        Coupon coupon = new Coupon();
        coupon.setBusinessId(businessId);
        coupon.setDescription(description);
        coupon.setCity(cityId);
        couponRepository.save(coupon);
        return "Coupon issued";
    }

    @GetMapping(path="/findCouponsByCity")
    public @ResponseBody List<Coupon> findCouponsByCity(@RequestParam String cityName,
        @RequestParam String page, @RequestParam String limit) {
        int offset = (Integer.parseInt(page) - 1)* Integer.parseInt(limit);
        String queryString =
                "SELECT * " +
                "FROM coupon t1 " +
                "JOIN city t2 " +
                "ON t1.city_id = t2.city_location_id " +
                "WHERE t2.city_name="+ "'" + cityName+ "'" + " "+
                " LIMIT " + limit
                + " OFFSET " + offset ;
        Query query = entityManager.createNativeQuery(queryString);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);

        return (List<Coupon>) query
                .getResultList();
    }

    @GetMapping(path="/findCouponsByRegion")
    public @ResponseBody List<Coupon> findCouponsByRegion(@RequestParam String regionName,
        @RequestParam String page, @RequestParam String limit) {
        int offset = (Integer.parseInt(page) - 1)* Integer.parseInt(limit);
        String queryString =
                "SELECT * " +
                "FROM coupon t1 " +
                "JOIN city t2 " +
                "ON t1.city_id = t2.city_location_id " +
                "WHERE t2.region_name="+ "'" + regionName+ "'" + " "+
                " LIMIT " + limit
                + " OFFSET " + offset ;
        Query query = entityManager.createNativeQuery(queryString);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);

        return (List<Coupon>) query
                .getResultList();
    }

    @GetMapping(path="/findCouponsByState")
    public @ResponseBody List<Coupon> findCouponsByState(@RequestParam String stateName,
        @RequestParam String page, @RequestParam String limit) {
        int offset = (Integer.parseInt(page) - 1)* Integer.parseInt(limit);
        String queryString =
                "SELECT * " +
                "FROM coupon t1 " +
                "JOIN city t2 " +
                "ON t1.city_id = t2.city_location_id " +
                "WHERE t2.state_name="+ "'" + stateName+ "'" + " "+
                " LIMIT " + limit
                + " OFFSET " + offset ;
        Query query = entityManager.createNativeQuery(queryString);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);

        return (List<Coupon>) query
                .getResultList();
    }

    @GetMapping(path="/findCouponsByCountry")
    public @ResponseBody List<Coupon> findCouponsByCountry(@RequestParam String countryName,
        @RequestParam String page, @RequestParam String limit) {
        int offset = (Integer.parseInt(page) - 1)* Integer.parseInt(limit);
        String queryString =
                "SELECT * " +
                "FROM coupon t1 " +
                "JOIN city t2 " +
                "ON t1.city_id = t2.city_location_id " +
                "WHERE t2.country_name="+ "'" + countryName+ "'" + " "+
                " LIMIT " + limit
                + " OFFSET " + offset ;
        Query query = entityManager.createNativeQuery(queryString);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);

        return (List<Coupon>) query
                .getResultList();
    }

    @GetMapping(path="/getAllBusinesses")
    public @ResponseBody Iterable<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @GetMapping(path="/getAllCoupons")
    public @ResponseBody Iterable<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}