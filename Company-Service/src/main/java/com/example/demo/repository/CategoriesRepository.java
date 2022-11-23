package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Categories;

@Repository
public interface CategoriesRepository extends MongoRepository<Categories,String> {

	void deleteByname(String name);


}
