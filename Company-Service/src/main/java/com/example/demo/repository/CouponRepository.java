package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Coupon;



@Repository
public interface CouponRepository extends MongoRepository<Coupon,String> {

	void deleteByCode(String code);


}
