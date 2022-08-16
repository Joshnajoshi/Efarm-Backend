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

import com.wipro.velocity.efarm.model.Bidder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BidderControllerTest {
	
	 @Autowired
	 private TestRestTemplate restTemplate;
	 
	    @LocalServerPort
	    int randomServerPort;
	    
	    
	    @Test
	    public void testAddBidderSuccess() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/eFam/bidder/register";
	        URI uri = new URI(baseUrl);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true"); 
	        Bidder b=new Bidder(null, "joshna", "525252", "j@gmail.com", "wwee", "manikonda", "manikonda", "telangana", "530011", "521021", "2525", "joshan");
	 
	        HttpEntity<Bidder> request = new HttpEntity<>(b, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	    }

}
