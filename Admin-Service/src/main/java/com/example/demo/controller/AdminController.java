package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CompanyDetails;
import com.example.demo.entity.Customer;
import com.example.demo.service.AdminService;


@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	//ADMINSERVICE
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RestTemplate template;
	
	
	/**
     * User methods
     */
	
	//GET USERDETAILS
	
	@RequestMapping("/user")
	public List<Customer> getAllCustomers()
	{
		return adminService.getAllCustomers();
	}
	
	
	//CREATE new USERDETAILS
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public Customer addCustomer(@RequestBody Customer customer)
	{
	return adminService.addCustomer(customer);
	}
	
	//UPDATE USERDETAILS BY ID
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{id}")
	public void UpdateCustomer(@RequestBody Customer customer,@PathVariable String id)
	{
	   adminService.UpdateCustomer(id,customer);
	}
	
	//DELETE USERDETAILS BY ID
	
	@RequestMapping(method=RequestMethod.DELETE, value="/user/{id}")
	public void deleteCustomer(@PathVariable String id)
	{
	   adminService.deleteCustomer(id);
	}
	
	
	 /**
     * COMPANY methods
     */
	
	// GET COMPANYDETAILS
	
	@RequestMapping("/companydetails")
	public List<CompanyDetails> getAllCompanyDetails()
	{
		return adminService.getAllCompany();
	}
	
	//CREATE new COMPANYDETAILS
	
	@RequestMapping(method=RequestMethod.POST, value="/companydetails")
	public void createCompany(@RequestBody CompanyDetails company)
	{
	    adminService.createCompany(company);
	}
	
	//UPDATE COMPANYDETAILS BY ID
	
	@RequestMapping(method=RequestMethod.PUT, value="/companydetails/{id}")
	public void UpdateCompany(@RequestBody CompanyDetails company,@PathVariable String id)
	{
	   adminService.UpdateCompany(id,company);
	}
	
	//DELETE COMPANYDETAILS BY ID
	
	@RequestMapping(method=RequestMethod.DELETE, value="/companydetails/{id}")
	public void deleteCompany(@PathVariable String id)
	{
	   adminService.deleteCompany(id);
	}
	
	
	//GET COMAPANY DETAILS FROM COMPANY SERVICE(INTERCONNECTION)
	
	@RequestMapping("/company/admin")
	public String getAllCompany()
	{
		String url="http://localhost:8093/company";
		return template.getForObject(url, String.class);
	}
}
