package com.wipro.velocity.efarm.controller;

import java.net.URI;
import java.net.URISyntaxException;

import com.wipro.velocity.efarm.model.Claim;
import com.wipro.velocity.efarm.model.Policy;

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
public class ClaimControllerTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;
	 
	    @LocalServerPort
	    int randomServerPort;
	    
	    
	    @Test
	    public void testAddClaimSuccess() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/eFam/insurance/claim";
	        URI uri = new URI(baseUrl);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true"); 
	        Claim i=new Claim( "1234", "winter", "2022", "10000",null, "vizag", null);
	 
	        HttpEntity<Claim> request = new HttpEntity<>(i, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	    }
	    
	    @Test
	    public void testAddPolicySuccess() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/eFam/insurance/policy";
	        URI uri = new URI(baseUrl);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true"); 
	        Policy p=new Policy(  "winter", "2022", "10000",null, "vizag", null);
	 
	        HttpEntity<Policy> request = new HttpEntity<>(p, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	    }


}
