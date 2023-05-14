	package com.Seats_Service.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Seats_Service.Entity.SeatsEntity;
import com.Seats_Service.Service.seatsService;

@RestController
@RequestMapping("/seats")
public class seatsController {
	
	@Autowired
	seatsService seatserv;
	
	private final Logger log = LoggerFactory.getLogger(seatsController.class);
		
	
	
	@PostMapping("/pvr")
	public String [][] pvrseats(@RequestBody  SeatsEntity moviedetails) {
		
	//	System.out.println("************************into it");
		
	
	System.out.println(moviedetails.getTheatername());
	System.out.println(moviedetails.getMoviename());
	System.out.println(moviedetails.getScreen());
    System.out.println(moviedetails.getMovietime());
				
		return 	seatserv.pvrseats(moviedetails);
		
			
	}
	
	@PostMapping("/ags")
	public String[][] agsseats(@RequestBody  SeatsEntity agsbody) {
	
		System.out.println("************************into ags controller");
		
		return seatserv.agsseats(agsbody);
		
	}
	
	@PostMapping("/inox")
	public String[][] inoxseats(@RequestBody  SeatsEntity inoxbody) {
		
		System.out.println("************************into inox controller");
		
		
		return seatserv.inoxseats(inoxbody);
		
	}
	
	@PostMapping("/confirmpvrticket")
	public String confirmPVRticket(@RequestBody SeatsEntity pvrconfirmrequest) {
		
		System.out.println("into confirmpvrticket controller"); 
		
		System.out.println(pvrconfirmrequest.getTheatername());
		System.out.println(pvrconfirmrequest.getMoviename());
		System.out.println(pvrconfirmrequest.getMovietime());
		System.out.println(pvrconfirmrequest.getScreen());
		System.out.println(pvrconfirmrequest.getSeatnumber());
       
		String servresp = seatserv.confirmPVRticket(pvrconfirmrequest);

		
		
		return servresp ;
	}	
	
	@PostMapping("confirmagsticket")
	public String confirmAGSticket(@RequestBody SeatsEntity agsconfirmrequest) {
       
		System.out.println("into confirmagsticket controller"); 
		
		String servresp = seatserv.confirmAGSticket(agsconfirmrequest);

		return servresp ;
	}

	@PostMapping("/confirminoxticket")
	public String confirmINOXticket(@RequestBody SeatsEntity inoxconfirmrequest) {
		
		
       
		System.out.println("into  confirminoxticket  controller"); 
		
		String servresp = seatserv.confirmINOXticket(inoxconfirmrequest);

		return servresp ;
	}
	
		
	
	

}
