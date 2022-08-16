package com.wipro.velocity.efarm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Crop")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Crop {
	
	@Id
	private String id;
	private String cropType;
	private String cropName;
	private String fertilizerType;
	private String quantity;
	private String price;
	private String soilpH;
	
}
