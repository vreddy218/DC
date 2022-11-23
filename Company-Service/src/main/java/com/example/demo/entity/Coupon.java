package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document(collection="coupon_details")
//@CompoundIndexes({
//@CompoundIndex(name = "code_idx", def = "{'code' : 1}", unique = true, background = true)})
public class Coupon {


	@Transient
	public static final String SEQUENCE_NAME = "coupon_sequence";

   
	@Id 
	private String databaseid;

	//available coupons automatic generated
	private int  availcoupons;

	 
	private String code; 
	 
	private  String discount; 
	
	//local date&time printed 

	ZoneId zoneId = ZoneId.of("America/Chicago");
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss",timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Indexed(name="createdAtIndex1",expireAfter="50s")
	private LocalDateTime createdDate = LocalDateTime.now(zoneId);
	
	
	private String image;

    //coupon will be expired after 40seconds days
	
	@LastModifiedDate
	
	private LocalDateTime lastModifiedDate= LocalDateTime.now(zoneId);
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}




	


	public String getDatabaseid() {
		return databaseid;
	}

	public void setDatabaseid(String databaseid) {
		this.databaseid = databaseid;
	}

	

	public Coupon(String databaseid, int availcoupons, String code, String discount, LocalDateTime createdDate,
			LocalDateTime lastModifiedDate, String image) {
		super();
		this.databaseid = databaseid;
		this.availcoupons = availcoupons;
		this.code = code;
		this.discount = discount;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.image = image;
	}

	public int getAvailcoupons() {
		return availcoupons;
	}

	public void setAvailcoupons(int availcoupons) {
		this.availcoupons = availcoupons;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}




	public Coupon() {

	}

	





}

