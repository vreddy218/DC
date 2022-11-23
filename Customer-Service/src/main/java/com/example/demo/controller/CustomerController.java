package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	

	
	

	
	
	@Autowired
	private RestTemplate template;
	
	//GET COMAPANY DETAILS FROM COMPANY SERVICE
//	
//	@RequestMapping("/customer/categories")
//	public String getAllCategories()
//	{
//		String url="http://localhost:8093/categories";
//		return template.getForObject(url, String.class);
//	}
	
	@RequestMapping("/customer/coupon")
	public String getAllCoupons()
	{
		String url="http://localhost:8093/coupon";
		return template.getForObject(url, String.class);
	}

	/* @GetMapping("/coupons/{couponId}")
	    public ResponseEntity<?> purchaseCoupon(@RequestBody Customer customer,@PathVariable String code) throws CouponSystemException {
	        customerService.purchaseCoupon(customer,code);
			return new ResponseEntity<>(HttpStatus.OK);
	    }
*/
}
