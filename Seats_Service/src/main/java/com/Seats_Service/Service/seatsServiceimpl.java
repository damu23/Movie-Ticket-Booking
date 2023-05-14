package com.Seats_Service.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Seats_Service.Entity.SeatsEntity;
import com.Seats_Service.Repository.seatsreposiroty;


@Service
public class seatsServiceimpl implements seatsService{

	@Autowired
	RestTemplate resttemplate;
	
	@Autowired
	seatsreposiroty seatsrepo;
	
	Seats_arrangements seatarrangments = new Seats_arrangements();
	
	
	String [][] pvrA1seats = seatarrangments.pvrA1();
	
	String [][] pvrA2seats = seatarrangments.pvrA2();
	
	String [][] agsA1seats = seatarrangments.agsA1seats();
	
	String [][] agsA2seats = seatarrangments.agsA2seats();
	
	String [][] inoxA1seats = seatarrangments.inoxA1seats();
	
	String [][] inoxA2seats = seatarrangments.inoxA2seats();
	
	 final Logger log = LoggerFactory.getLogger(seatsServiceimpl.class);
	 

	 //pvrseats
  @Override
	public String [][] pvrseats(SeatsEntity moviedetails) {

		if(moviedetails.getScreen().equalsIgnoreCase("A1") 
				&& moviedetails.getTheatername().equalsIgnoreCase("pvr")){
			
		log.info("into A1");
		
	
		HttpHeaders htpheaders = new HttpHeaders();
		htpheaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> htpentity = new HttpEntity<>(moviedetails,htpheaders);
		
		resttemplate.exchange
		("http://AVAILABLITY-SERVICE/availablitychecker/pvroccupied", 
				HttpMethod.POST,htpentity,SeatsEntity.class);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SeatsEntity[] AvailablityresponsesA1 =	resttemplate.getForObject
				("http://AVAILABLITY-SERVICE/availablitychecker/getpvroccupied",
						SeatsEntity[].class);
		
			
			for  (SeatsEntity AvailablityresponseA1 : AvailablityresponsesA1 ) {
			
				if (AvailablityresponseA1.getMovietime()
						.equalsIgnoreCase(moviedetails.getMovietime()) ) {
				
				 String Avr_seatnum = //c4
						 AvailablityresponseA1.getSeatnumber();
				 
				 // populate the booked seats
				 for(int i = 1 ; i < 11;i++) {
					 for(int j = 1 ; j < 11 ; j++ ) {
						 
						 if (pvrA1seats[i][j].equalsIgnoreCase(Avr_seatnum)) {
							pvrA1seats[i][j] =  pvrA1seats[i][j]+  "x";
							// System.out.print(pvrA1seats[i][j] + " ");
						 }
						 else {
						// System.out.print(pvrA1seats[i][j] + "  ");
						 }
					 }
					 //System.out.println();
					// System.out.println("*****************");
				 }
			}
			}
			
			for (int i = 1  ; i < pvrA1seats.length ; i++) {
				for(int j =1 ; j < pvrA1seats[i].length ; j++ ) {
					//System.out.print(pvrA1seats[i][j] + " ") ;
				}
				//System.out.println();
			}
			
			return pvrA1seats  ;
			////////////////////////////////////////////////////////////
		}
		else if(moviedetails.getScreen().equalsIgnoreCase("A2") 
				&& moviedetails.getTheatername().equalsIgnoreCase("pvr") ) {
			
			
			HttpHeaders htpheaders = new HttpHeaders();
			htpheaders.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<?> htpentity = new HttpEntity<>(moviedetails,htpheaders);
			
			resttemplate.exchange
			("http://AVAILABLITY-SERVICE/availablitychecker/pvroccupied", 
					HttpMethod.POST,htpentity,SeatsEntity.class);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SeatsEntity [] availablityresposesA2 = resttemplate.getForObject
			 ("http://AVAILABLITY-SERVICE/availablitychecker/getpvroccupied",
					 SeatsEntity[].class); 
	 
	     for(SeatsEntity availablityresposeA2 : availablityresposesA2 ) {
	 
	    	 if(availablityresposeA2.getMovietime().
	    			 equalsIgnoreCase(moviedetails.getMovietime())) {
	    		 
	    		 String Avr_seatnum = 
	    				 availablityresposeA2.getSeatnumber();
	    	 
	     for(int i = 1 ; i < pvrA2seats.length ; i++) {
	    	 for(int j = 1 ; j < pvrA2seats[i].length ; j++) {
	    	
	    		 if(pvrA2seats[i][j].equalsIgnoreCase
	    				 (Avr_seatnum)) {
	    			 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
	    			 pvrA2seats[i][j] += "x"; 
	    			 
	    		 }
	    		 
	    	 }
	     }
	          
	     }
				
	     }
	 	for (int i = 1  ; i < pvrA2seats.length ; i++) {
			for(int j =1 ; j < pvrA2seats[i].length ; j++ ) {
				//System.out.print(pvrA2seats[i][j] + " ") ;
			}
			///System.out.println();
		}
	     
		
	     return pvrA2seats ;
		}
		return null ;
		
	}
	
	//agsseats
	@Override
	public String[][] agsseats(SeatsEntity agsbody) {
				
		if(agsbody.getScreen().equalsIgnoreCase("A1") 
				&& agsbody.getTheatername().equalsIgnoreCase("ags") ){
						
			HttpHeaders htpheaders = new HttpHeaders();
			htpheaders.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<?> htpentity = new  HttpEntity<>(agsbody,htpheaders);
			
		resttemplate.exchange("http://AVAILABLITY-SERVICE/availablitychecker/agsoccupied", 
				HttpMethod.POST, htpentity, SeatsEntity.class);	
			
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}		
			
			
	SeatsEntity[] agsA1seatsbooked = resttemplate.getForObject
			("http://AVAILABLITY-SERVICE/availablitychecker/getagsoccupied", SeatsEntity[].class)  ;
			
			for(SeatsEntity agsA1seatbooked : agsA1seatsbooked) {
				
				if(agsbody.getMovietime().equalsIgnoreCase(agsA1seatbooked.getMovietime())){
				
					String agsA1seatnumber = agsA1seatbooked.getSeatnumber();
					
					for(int i = 1 ; i < agsA1seats.length ; i++) {
					  for(int j = 1 ; j < agsA1seats[i].length ; j++) {
						  
					if(agsA1seats[i][j].equalsIgnoreCase
							(agsA1seatnumber)){
						agsA1seats[i][j] = agsA1seats[i][j] + "x" ;
					}		
						}
					}	
				}
			}
			
			for(int i = 1 ; i < agsA1seats.length ; i++) {
				for(int j = 1  ; j < agsA1seats[i].length ; j++) {
					//System.out.print(agsA1seats[i][j] + " ");
				}
				//System.out.println();
			}
			
			
			return agsA1seats ;
			
			
		}
		else if(agsbody.getScreen().equalsIgnoreCase("A2") 
				&& agsbody.getTheatername().equalsIgnoreCase("ags") ) {
			
			
			HttpHeaders htpheaders = new HttpHeaders();
			htpheaders.setContentType(MediaType.APPLICATION_JSON);
			
			
			HttpEntity<?> htpentity = new HttpEntity<Object>(agsbody,htpheaders);
			
			resttemplate.exchange("http://AVAILABLITY-SERVICE/availablitychecker/agsoccupied",HttpMethod.POST,
					htpentity,SeatsEntity.class);
			
			try { Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			
			SeatsEntity[] agsA2seatsbooked = resttemplate.getForObject
					("http://AVAILABLITY-SERVICE/availablitychecker/getagsoccupied", SeatsEntity[].class)  ;
					
					for(SeatsEntity agsA2seatbooked : agsA2seatsbooked) {
						
						if(agsbody.getMovietime().equalsIgnoreCase(agsA2seatbooked.getMovietime())){
						
							 String Avr_seatnum = //c4
									 agsA2seatbooked.getSeatnumber();
							
							
							for(int i = 1 ; i < agsA2seats.length ; i++) {
							  for(int j = 1 ; j < agsA2seats[i].length ; j++) {
								  
							if(agsA2seats[i][j].equalsIgnoreCase
									(Avr_seatnum)){
								agsA2seats[i][j] = agsA2seats[i][j] + "x" ;
							}		
								}
							}	
						}
					}
					
					for(int i = 1 ; i < agsA2seats.length ; i++) {
						for(int j = 1  ; j < agsA2seats[i].length ; j++) {
						//	System.out.print(agsA2seats[i][j] + " ");
						}
						//System.out.println();
					}
					return agsA2seats ;
						
		}
					
		return null ;
		
	}

	//inoxseats
	@Override 
	public String[][] inoxseats(SeatsEntity inoxbody) {
		
		
		if(inoxbody.getScreen().equalsIgnoreCase("A1")){
			
			
			HttpHeaders htpheaders = new HttpHeaders();
			htpheaders.setContentType(MediaType.APPLICATION_JSON);
			
			
			HttpEntity<?> htpentity = new HttpEntity<Object>(inoxbody,htpheaders);
			
			resttemplate.exchange("http://AVAILABLITY-SERVICE/availablitychecker/inoxoccupied",HttpMethod.POST,
					htpentity,SeatsEntity.class);
			
	
			try { Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace(); }
			
	SeatsEntity[] inoxA1seatsbooked = resttemplate.getForObject
			("http://AVAILABLITY-SERVICE/availablitychecker/getinoxoccupied", SeatsEntity[].class)  ;
			
			for(SeatsEntity inoxA1seatbooked : inoxA1seatsbooked) {
				
				if(inoxbody.getMovietime().equalsIgnoreCase(inoxA1seatbooked.getMovietime())){
				
					for(int i = 1 ; i < inoxA1seats.length ; i++) {
					  for(int j = 1 ; j < inoxA1seats[i].length ; j++) {
						  
					if(inoxA1seats[i][j].equalsIgnoreCase
							(inoxA1seatbooked.getSeatnumber())){
						inoxA1seats[i][j] = inoxA1seats[i][j] + "x" ;
					}		
						}
					}	
				}
			}
			for(int i = 1 ; i < inoxA1seats.length ; i++) {
				for(int j = 1  ; j < inoxA1seats[i].length ; j++) {
				//	System.out.print(inoxA1seats[i][j] + " ");
				}
			//	System.out.println();
			}
			return inoxA1seats ;
			
			
		}
		else if(inoxbody.getScreen().equalsIgnoreCase("A2")) {
			
			System.out.println("into service inox A2");

			HttpHeaders htpheaders = new HttpHeaders();
			htpheaders.setContentType(MediaType.APPLICATION_JSON);
			
			
			HttpEntity<?> htpentity = new HttpEntity<Object>(inoxbody,htpheaders);
			
			resttemplate.exchange("http://AVAILABLITY-SERVICE/availablitychecker/inoxoccupied",HttpMethod.POST,
					htpentity,SeatsEntity.class);
			
			try { Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace(); }			
			
			
			SeatsEntity[] inoxA2seatsbooked = resttemplate.getForObject
					("http://AVAILABLITY-SERVICE/availablitychecker/getinoxoccupied", SeatsEntity[].class)  ;
					
					for(SeatsEntity inoxA2seatbooked : inoxA2seatsbooked) {
						
						 String Avr_seatnum = //c4
								 inoxA2seatbooked.getSeatnumber();
						
						
				if(inoxbody.getMovietime().equalsIgnoreCase(inoxA2seatbooked.getMovietime())){
						
							for(int i = 1 ; i < inoxA2seats.length ; i++) {
							  for(int j = 1 ; j < inoxA2seats[i].length ; j++) {
								  
							if(inoxA2seats[i][j].equalsIgnoreCase
									(Avr_seatnum)){
								inoxA2seats[i][j] = agsA2seats[i][j] + "x" ;
							}		
								}
							}	
						}
					}
					
					for(int i = 1 ; i < inoxA2seats.length ; i++) {
						for(int j = 1 ; j <  inoxA2seats[i].length ; j++ ) {
						//	System.out.print(inoxA2seats[i][j] + " ");
						}
					//	System.out.println();
					}
					
					
					return inoxA2seats ;
						
		}
					
		return null ;
		
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String confirmPVRticket(SeatsEntity pvrconfirmrequest) {
	
		System.out.println("into pvrconfirmrequest service layer ");	
		
		
		String [] [] pveseats = pvrseats(pvrconfirmrequest);
		
		String requestedseatnum = pvrconfirmrequest.getSeatnumber();
		
		System.out.println(requestedseatnum);
		
		for(int i = 1 ; i < pveseats.length ; i ++ ) {
			for(int j = 1 ; j < pveseats[i].length ; j++) {
				   
			
				
				if(pveseats[i][j].equalsIgnoreCase(requestedseatnum)) {
					
					System.out.println("into pvr if");
					
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				HttpEntity<?> entity = new HttpEntity<Object>(pvrconfirmrequest,headers);
				
				resttemplate.exchange("http://TICKET-CONFIRMATION/confirmation/confirmedticket",
	    				HttpMethod.POST, entity, SeatsEntity.class);
				
				System.out.println("your seat booked ");
				
				return "your seat booked " ;
				
				}
			}
		}
		return " your seat not booked "; 
			}
/////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String confirmAGSticket(SeatsEntity agsconfirmrequest) {

		
		System.out.println("into agsconfirmrequest service layer ");		
		
		String [] [] agsseats = agsseats(agsconfirmrequest);
		
		String requestedseatnum = agsconfirmrequest.getSeatnumber();
		
		for(int i = 1 ; i < agsseats.length ; i ++ ) {
			for(int j = 1 ; j < agsseats[i].length ; j++) {
				   
				if(agsseats[i][j].equalsIgnoreCase(requestedseatnum)) {
					
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				HttpEntity<?> entity = new HttpEntity<Object>(agsconfirmrequest,headers);
				
				resttemplate.exchange("http://TICKET-CONFIRMATION/confirmation/confirmedticket",
	    				HttpMethod.POST, entity, SeatsEntity.class);
				
				System.out.println("your seat booked ");
				
				return "your seat booked " ;
				
				}
			}
		}
		return " your seat not booked "; 	
	}


	
	@Override
public String confirmINOXticket(SeatsEntity inoxconfirmrequest) {
	
	System.out.println("into inoxconfirmrequest service layer ");		
		
		String [] [] inoxseats = inoxseats(inoxconfirmrequest);
		
		String requestedseatnum = inoxconfirmrequest.getSeatnumber();
		
		for(int i = 1 ; i < inoxseats.length ; i ++ ) {
			for(int j = 1 ; j < inoxseats[i].length ; j++) {
				   
				if(inoxseats[i][j].equalsIgnoreCase(requestedseatnum)) {
					
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				HttpEntity<?> entity = new HttpEntity<Object>(inoxconfirmrequest,headers);
				
				resttemplate.exchange("http://TICKET-CONFIRMATION/confirmation/confirmedticket",
	    				HttpMethod.POST, entity, SeatsEntity.class);
				
				System.out.println("your seat booked ");
				
				return "your seat booked " ;
				
				}
			}
		}
		return " your seat not booked "; 	
		
}






	

	}
	

