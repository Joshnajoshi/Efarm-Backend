package com.wipro.velocity.efarm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Policy")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Policy {
	@Id
	private String id;
	private String season;
	private String year;
	private String crop;
	private String sumInsured;
	private String area;
	

}
