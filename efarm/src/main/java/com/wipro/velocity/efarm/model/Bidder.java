package com.wipro.velocity.efarm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Bidder")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bidder {
	
	@Id
	private String id;
	private String fullName;
	private String contactNo;
	private String email;
    private String address1;
	private String address2;
    private String city;
	private String state;
	private String pincode;
	private String aadharNo;
	private String panNo;
	private String password;

}
