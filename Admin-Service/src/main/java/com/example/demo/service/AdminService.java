package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CompanyDetails;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CompanyDetailsRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AdminService{

	//User
	@Autowired
	private UserRepository userRepository;

	//Company
	@Autowired
	private CompanyDetailsRepository  companyRepository;


	/**
	 * User methods
	 */

	public List<Customer> getAllCustomers()
	{
		List<Customer> users=new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}

	public Customer addCustomer(Customer customer)

	{
		return userRepository.save(customer);
	}
	public void UpdateCustomer(String id, Customer customer) {
		userRepository.save(customer);

	}
	public void deleteCustomer(String id) {
		userRepository.deleteById(id);

	}
	
	 /**
     * COMPANY methods
     */
	
	public List<CompanyDetails> getAllCompany()
	{
		List<CompanyDetails> companies=new ArrayList<>();
		companyRepository.findAll()
		.forEach(companies::add);
		return companies;
	}

	public void createCompany(CompanyDetails company)

	{
		companyRepository.save(company);
	}
	
	public void UpdateCompany(String id, CompanyDetails company) {
		companyRepository.save(company);

	}
	
	public void deleteCompany(String id) {
		companyRepository.deleteById(id);

	}



}


