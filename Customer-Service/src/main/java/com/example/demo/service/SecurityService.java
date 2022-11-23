package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class SecurityService implements UserDetailsService {
	
	@Autowired 
	private CustomerRepository customerRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

		Customer foundedUser=customerRepository.findByUsername(username);
		if(foundedUser==null) return null;
		
		
		String name=foundedUser.getUsername();
		String pwd=foundedUser.getPassword();
		String email=foundedUser.getEmail();
		return new User(name,pwd,new ArrayList<>());
	
		
}


	
}


