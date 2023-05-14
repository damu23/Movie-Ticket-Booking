package com.ticketconfirmation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ticketconfirmation.Entity.ConfirmationEntity;
import com.ticketconfirmation.Repository.ConfirmationRepo;

@Service
public class ConfirmationServiceimpl implements ConfirmationService {

	@Autowired
	ConfirmationRepo confirmationrepo ;
	
	@Autowired
	RestTemplate resttemplate;
	
	
	@Override
	public ConfirmationEntity saveconfirmedticket(ConfirmationEntity confirmedticket) {
			
//		confirmationrepo.save(confirmedticket);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> htpentity = new HttpEntity<Object>(confirmedticket,headers);
		
		resttemplate.exchange
		("http://AVAILABLITY-SERVICE/availablitychecker/insertbooking", 
				HttpMethod.POST,htpentity,ConfirmationEntity.class);
		
		confirmationrepo.save(confirmedticket);
		
		System.out.println("saved");
		
		return null ;
	}

}
