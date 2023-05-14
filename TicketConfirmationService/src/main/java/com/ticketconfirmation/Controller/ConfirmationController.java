package com.ticketconfirmation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketconfirmation.Entity.ConfirmationEntity;
import com.ticketconfirmation.Service.ConfirmationService;

@RestController
@RequestMapping("/confirmation")
public class ConfirmationController {
	
    @Autowired
	ConfirmationService confirmationservice;
    
    

	@PostMapping("/confirmedticket")
	public ConfirmationEntity 	ticketconfirmation(@RequestBody  ConfirmationEntity confirmedticket ) {
		
		System.out.println("into confirmedticket  controller ");
		
	return confirmationservice.saveconfirmedticket(confirmedticket);
		
	}
	
	
	
	
	
}
