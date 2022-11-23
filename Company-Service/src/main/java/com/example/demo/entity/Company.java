package com.example.demo.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Document(collection="CompaniesUI")

public class Company {

	//GENERATE AUTO SEQUENCE FOR AVAILCOUPONS



	//GENERATE AUTO OBJECTID 

	@Id
	private String id;
	



	//COMPANY NAME
	private  String comname;

	//LIST OF CATEGORIES CLASS
	private  String categories;
	
	
	private String image;

	
	/*
	 *GETTERS AND SETTERS
	 */

	public Company() {

	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getComname() {
		return comname;
	}


	public void setComname(String comname) {
		this.comname = comname;
	}


	public String getCategories() {
		return categories;
	}


	public void setCategories(String categories) {
		this.categories = categories;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Company(String id, String comname, String categories, String image) {
		super();
		this.id = id;
		this.comname = comname;
		this.categories = categories;
		this.image = image;
	}


//	@Override
//	public String toString() {
//		return "Company [id=" + id + ", comname=" + comname + ", categories=" + categories + ", image=" + image + "]";
//	}


	


	





}
