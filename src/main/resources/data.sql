# City Seed Data
GRANT ALL PRIVILEGES ON coupondb  TO 'root'@'localhost'

INSERT INTO city (city_location_id, city_name, country_name, region_name, state_name) VALUES (1,"San Jose", "US", "West Bay", "California");
INSERT INTO city (city_location_id, city_name, country_name, region_name, state_name) VALUES (1,"San Jose", "US", "West Bay", "California");
INSERT INTO city (city_location_id, city_name, country_name, region_name, state_name) VALUES (2,"Oakland", "US", "East Bay", "California");
INSERT INTO city (city_location_id, city_name, country_name, region_name, state_name) VALUES (3,"Cupertino", "US", "West Bay", "California");
INSERT INTO city (city_location_id, city_name, country_name, region_name, state_name) VALUES (4,"San Francisco", "US", "West Bay", "California");
INSERT INTO city (city_location_id, city_name, country_name, region_name, state_name) VALUES (5,"Milipitas", "US", "East Bay", "California");

# Business Seed Data
INSERT INTO business (business_id, business_name) VALUES (1, "Company1");
INSERT INTO business (business_id, business_name) VALUES (2, "Company2");
INSERT INTO business (business_id, business_name) VALUES (3, "Company3");

# Coupon Seed Data
INSERT INTO coupon (coupon_id, business_id, description, city_id) VALUES (1,1,"Food Coupon 50% Off", 2);
INSERT INTO coupon (coupon_id, business_id, description, city_id) VALUES (1,1,"Food Coupon 50% Off", 2);
INSERT INTO coupon (coupon_id, business_id, description, city_id) VALUES (2,1,"Uber Coupon 50% Off", 3);
INSERT INTO coupon (coupon_id, business_id, description, city_id) VALUES (3,1,"Movie Coupon 50% Off", 3);