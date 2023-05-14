	package com.movie_service.Service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie_service.Entity.MovieEntity;
import com.movie_service.Entity.SeatsEntity;
import com.movie_service.Entity.TheaterEntity;
//import com.movie_service.Entity.MovieInsertEntity;
import com.movie_service.Repository.MoviesRepository;
import com.movie_service.Repository.TheaterRepo;
import com.netflix.discovery.converters.Auto;

@Service
public class MovieServiceimpl implements MovieService {

	@Autowired
	MoviesRepository movierepo;
	
	@Autowired
	TheaterRepo theaterrepo ;
	
	@Autowired
	RestTemplate resttemplate;
	
	 final Logger log = LoggerFactory.getLogger(MovieServiceimpl.class);
	 


	@Override
	public MovieEntity[] gettheater(MovieEntity selctedmoviedetails) {
		
	 log.info( "inside movie service layer " + selctedmoviedetails.getTheatername());
	
		
 	MovieEntity[] mie =  resttemplate.getForObject
				("http://MOVIEINSERT-SERVICE/insertmoviesfortheater/getmoviesbytheatername/" +
 	selctedmoviedetails.getTheatername() ,
						MovieEntity[].class) ;
	 
	 for(MovieEntity mieitr : mie) {
		 System.out.println(mieitr.getTheatername());
		 System.out.println(mieitr.getMoviename());
		 System.out.println(mieitr.getMovietime());
		 System.out.println(mieitr.getScreen());
		 System.out.println("**********************");

	 }
	 
	 return mie ;
	    
	}
	
	
	@Override
	public String[][] pushmoviedetails(MovieEntity selctedmoviedetails) throws InterruptedException {

		  HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
	
		    HttpEntity<?> entity = new HttpEntity<Object>(selctedmoviedetails,headers);
		    
//		    try {
////		   // ResponseEntity<MovieEntity> responseentity =
////		    		resttemplate.exchange("http://localhost:8113/seats/pvr",
////		    				HttpMethod.POST, entity, MovieEntity.class);
//				
//				   // ResponseEntity<MovieEntity> responseentity =
//	    		resttemplate.exchange("http://SEATS-SERVICE/seats/pvr",
//	    				HttpMethod.POST, entity, MovieEntity.class);
//			}
//			catch(Exception e) {	System.out.println(e);		}
//			
//		    		Thread.sleep(1000);
		    		
//		    		String [][] pvrSeats = resttemplate.getForObject
//		    				("http://localhost:8113/seats/getpvrseatarrangements", String[][].class);

		    		if(selctedmoviedetails.getTheatername().equalsIgnoreCase("pvr") && 
		    				selctedmoviedetails.getScreen().equalsIgnoreCase("A1")	) {
		     
		    			ResponseEntity<String[][]> pvrresponseA1 = resttemplate.exchange("http://SEATS-SERVICE/seats/pvr",
		    				HttpMethod.POST, entity, String[][].class);
		    			
		    			String[][] pvrseatsavilA1 = pvrresponseA1.getBody();
		    			

		    		return pvrseatsavilA1 ;
		    		}
		    		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("pvr") && 
		    				selctedmoviedetails.getScreen().equalsIgnoreCase("A2")	) {
		    			
		    			ResponseEntity<String[][]> pvrresponseA2 = resttemplate.exchange("http://SEATS-SERVICE/seats/pvr",
			    				HttpMethod.POST, entity, String[][].class);
			    			
			    			String[][] pvrseatsavilA2 = pvrresponseA2.getBody();
			    			

			    		return pvrseatsavilA2 ;
		    			
		    			
//		    		String [][] pvrSeatsA2 = resttemplate.getForObject
//		    				("http://SEATS-SERVICE/seats/getpvrseatarrangementsA2", String[][].class);
//		    		return pvrSeatsA2 ;
		    		}
		    		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("ags") && 
		    				selctedmoviedetails.getScreen().equalsIgnoreCase("A1")	) {

		    			ResponseEntity<String[][]> agsresponseA1 = resttemplate.exchange("http://SEATS-SERVICE/seats/ags",
			    				HttpMethod.POST, entity, String[][].class);
			    			
			    			String[][] agsseatsavilA1 = agsresponseA1.getBody();
			    			

			    		return agsseatsavilA1 ;
		    		}
		    		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("ags") && 
		    				selctedmoviedetails.getScreen().equalsIgnoreCase("A2")	) {
		    			
		    			ResponseEntity<String[][]> agsresponseA2 = resttemplate.exchange("http://SEATS-SERVICE/seats/ags",
			    				HttpMethod.POST, entity, String[][].class);
			    			
			    			String[][] agsseatsavilA2 = agsresponseA2.getBody();			    			

			    		return agsseatsavilA2 ;

		    		}
		    		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("inox") && 
		    				selctedmoviedetails.getScreen().equalsIgnoreCase("A1")	) {
		    			ResponseEntity<String[][]> inoxresponseA1 = resttemplate.exchange("http://SEATS-SERVICE/seats/inox",
			    				HttpMethod.POST, entity, String[][].class);
			    			
			    			String[][] inoxseatsavilA1 = inoxresponseA1.getBody();
			    			

			    		return inoxseatsavilA1 ;
		    		
		    		}
		    		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("inox") && 
		    				selctedmoviedetails.getScreen().equalsIgnoreCase("A2")	) {
		    		
		    			ResponseEntity<String[][]> inoxresonseA2 = resttemplate.exchange("http://SEATS-SERVICE/seats/inox",
			    				HttpMethod.POST, entity, String[][].class);
			    			
			    			String[][] inoxseatsavilA2 = inoxresonseA2.getBody();
			    			

			    		return inoxseatsavilA2 ;
		    			
		    			
//		    		System.out.println("inside inoxSeatsA2 ");
//		    		for(int i = 1 ; i < inoxSeatsA2.length ; i++ ) {
//		    			for(int j = 1 ; j < inoxSeatsA2[i].length ; j++) {
//		    				System.out.print(inoxSeatsA2[i][j]);
//		    			}
//		    			System.out.println();
//		    		}
		    		

		    		}
		    		
		    		
		    movierepo.save(selctedmoviedetails);
		
		return null ;
	}




	@Override
	public TheaterEntity inserttheater(TheaterEntity insertabletheater) {
		
		return theaterrepo.save(insertabletheater);
	}


	@Override
	public TheaterEntity[] gettheaters() {
		
		System.out.println("********inside movie service service***************");
		
		
		TheaterEntity[] alltheaters = resttemplate.getForObject
 ("http://MOVIEINSERT-SERVICE/insertmoviesfortheater/getinsertedtheaters/",TheaterEntity[].class);
		
		return alltheaters ;
		
	}


	@Override
	public String ticketconfirmrequest(SeatsEntity ticketrequest) {
		
		HttpHeaders htpheaders = new HttpHeaders();
		htpheaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> htpentity = new HttpEntity<Object>(ticketrequest,htpheaders);
		
		
		if (ticketrequest.getTheatername().equals("pvr")) {
			
			ResponseEntity<String> pvrseatresponse = 				
					resttemplate.exchange
					("http://SEATS-SERVICE/seats/confirmpvrticket",
					HttpMethod.POST, htpentity, String.class);
					
					
			String pvrres = pvrseatresponse.getBody();
			
			return pvrres   ;
			
		}
        if (ticketrequest.getTheatername().equals("ags")) {
		
			ResponseEntity<String> agsseatresponse = resttemplate.exchange
					("http://SEATS-SERVICE/seats/confirmagsticket",
					HttpMethod.POST, htpentity, String.class);
			
			String agsres = agsseatresponse.getBody();
			
			return agsres   ;
        	
		}
        if (ticketrequest.getTheatername().equals("inox")) {
			
			ResponseEntity<String> inoxseatresponse = resttemplate.exchange
					("http://SEATS-SERVICE/seats/confirminoxticket",
					HttpMethod.POST, htpentity, String.class);
			
			String inoxres = inoxseatresponse.getBody();
			
			return inoxres   ;
        	
        	
		}
		
		return null;
	}








	
}
