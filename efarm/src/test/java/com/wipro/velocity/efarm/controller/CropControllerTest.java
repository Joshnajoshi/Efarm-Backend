package com.wipro.velocity.efarm.controller;


import java.net.URI;
import java.net.URISyntaxException;

import com.wipro.velocity.efarm.model.Crop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CropControllerTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;
	 
	    @LocalServerPort
	    int randomServerPort;
	    
	    
	    @Test
	    public void testAddCropSuccess() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/eFam/crop/register";
	        URI uri = new URI(baseUrl);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true"); 
	        Crop c=new Crop(null, "feedcrops", "corn", "nitrogen", "4000", "2000", "6");
	 
	        HttpEntity<Crop> request = new HttpEntity<>(c, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	    }

}

