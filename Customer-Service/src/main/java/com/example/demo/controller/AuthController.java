
package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.AuthenticationRequest;

import com.example.demo.entity.AuthenticationResponse;
import com.example.demo.entity.Customer;
import com.example.demo.jwtFilters.JwtUtils;
import com.example.demo.repository.CustomerRepository;

import com.example.demo.service.SecurityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SecurityService customerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/token")

	public String testingToken()
	{
		return "<h1>Welcome to Dashboard<h1>"; 
	}
	
	@PostMapping("/subs")
	
	public ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		String email=authenticationRequest.getEmail();
		
		Customer customer=new Customer();
		customer.setUsername(username);
		//customer.setPassword(password);
		 customer.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
		 customer.setEmail(email);
		 
		try {
			customerRepository.save(customer);
			}
		catch(Exception e)
		{
			return ResponseEntity.ok("Error during subscription");	
		}
		
		return ResponseEntity.ok("Successfully subcribed "+username);
	}
	
	
	
	 
	@PostMapping("/auth")
	
	public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		

		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}
		catch(Exception e)
		{
		return ResponseEntity.ok("Error during authentication");
		}
		
		UserDetails loadedUser=customerService.loadUserByUsername(username);
		
		String generatedToken=jwtUtils.generateToken(loadedUser);

		return ResponseEntity.ok(generatedToken );
		//return ResponseEntity.ok(new AuthenticationResponse("Successfully subcribed "+username));
	
}
	
	@Autowired
	private RestTemplate template;
	
	//GET COMAPANY DETAILS FROM COMPANY SERVICE
	
	@RequestMapping("/customer/categories")
	public String getAllCategories()
	{
		String url="http://localhost:8093/categories";
		return template.getForObject(url, String.class);
	}
}