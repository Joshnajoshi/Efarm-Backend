package com.wipro.velocity.efarm.controller;

import java.net.URI;
import java.net.URISyntaxException;

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

import com.wipro.velocity.efarm.model.Farmer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class FarmerControllerTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;
	 
	    @LocalServerPort
	    int randomServerPort;
	    
	    
	    @Test
	    public void testAddFarmerSuccess() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/eFam/farmer/register";
	        URI uri = new URI(baseUrl);
	    //    Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true"); 
	        Farmer f=new Farmer(null, "praveen", "9000730500", "p@gmail.com", "manikonda", "manikonda", "hyd", "ts", "hyd", "hyd", "hyd", "323100097", "iNdb001", "123456");
	 
	        HttpEntity<Farmer> request = new HttpEntity<>(f, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	    }

}
