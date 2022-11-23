package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Customer;



@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{

	Customer findByUsername(String username);

	



	
}
