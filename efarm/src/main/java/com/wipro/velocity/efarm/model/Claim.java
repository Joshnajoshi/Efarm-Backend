package com.wipro.velocity.efarm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Claim")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Claim {
	
	@Id
	private String id;
	private String policyNo;
	private String company;
	private String name;
	private String sumInsured;
	private String cause;
	private Date date; 
	
}
