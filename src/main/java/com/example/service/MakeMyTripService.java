package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bindings.Passanger;
import com.example.bindings.Ticket;

@Service
public class MakeMyTripService {
	
	public Ticket bookTicket(Passanger p) {
		
		String apiUrl="http://localhost:9090/ticket";
		
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<Ticket>	forEntity=rt.postForEntity(apiUrl, p, Ticket.class);
		
		Ticket body=forEntity.getBody();
		
		return body;
		
	}
	
	public List<Ticket> getAllTickets(){
		
		String apiUrl="http://localhost:9090/getTickets";
		RestTemplate rt=new RestTemplate();	
		ResponseEntity<Ticket[]>	forEntity=rt.getForEntity(apiUrl,Ticket[].class);
		Ticket[] body=forEntity.getBody();		
		List<Ticket> tickets=Arrays.asList(body);
		if (body ==null) {
	        System.out.println("No tickets received!");
	        return List.of();  // Return empty list instead of null
	    }

	    return Arrays.asList(body);
		
		
	
	}

}
