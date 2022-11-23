package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Company;
import com.example.demo.entity.Coupon;
import com.example.demo.service.CompanyService;



@RestController
@CrossOrigin(origins="*")
public class CompanyController {
	
	@Autowired
	private  CompanyService companyService;
	
	@RequestMapping("/coupon")
	public List<Coupon> getAllCoupons()
	{
		return companyService.getAllCoupon();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/coupon")
	public void addCoupon(@RequestBody Coupon coupon)
	{
		coupon.setAvailcoupons(companyService.getSequenceNumber(Coupon.SEQUENCE_NAME));
		companyService.addCoupon(coupon);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/coupon/{databaseid}")
	public void UpdateCoupon(@RequestBody Coupon coupon,@PathVariable String databaseid)
	{
		companyService.UpdateCoupon(databaseid,coupon);
	}
	
	@CrossOrigin(origins="http://loaclhost:4200")
	@RequestMapping(method=RequestMethod.DELETE, value="/coupon/{databaseid}")
	public void deleteCoupon(@PathVariable String databaseid)
	{
		companyService.deleteCoupon(databaseid);
	}
	
	/*
	 * *Company categories methods
	 */
	
	@RequestMapping("/categories")
	public List<Company> getAllCategories()
	{
		return companyService.getAllCategories();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories")
	public void addCategories(@RequestBody Company company)
	{
		//company.setAvailcoupons(companyService.getSequenceNumber(Coupon.SEQUENCE_NAME));
		companyService.addCategories(company);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/categories/{name}")
	public void UpdateCategories(@RequestBody Company company,@PathVariable String id)
	{
		companyService.UpdateCategories(id,company);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/categories/{id}")
	public void deleteCategories(@PathVariable String id)
	{
		companyService.deleteCategories(id);
	}
	 
}
