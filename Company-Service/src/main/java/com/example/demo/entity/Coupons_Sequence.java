package com.example.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="coupon-sequences")
@Component
public class Coupons_Sequence {
	@Id 
	private String id;

	private int seq;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public Coupons_Sequence() {

	}



}
