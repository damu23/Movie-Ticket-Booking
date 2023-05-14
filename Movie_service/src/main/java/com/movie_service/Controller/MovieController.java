package com.movie_service.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.movie_service.Entity.MovieEntity;
import com.movie_service.Entity.SeatsEntity;
import com.movie_service.Entity.TheaterEntity;
import com.movie_service.Service.MovieService;

@RestController
@RequestMapping("/selectmoviefromtheater")
public class MovieController {
	
	@Autowired
	MovieService movieservice;
	
	@Autowired
	RestTemplate resttemplate;
	
	  MovieEntity movieentity ;	
	  
	  private final Logger log = LoggerFactory.getLogger(MovieController.class);
	  
	    
	 // method mapping for the theater
//	@PostMapping("/selectedtheater")
	public MovieEntity[] maptheater( MovieEntity selctedmoviedetails  ) {
		
		log.info("inside movie controller layer" + selctedmoviedetails.getTheatername());
		
		
			return gettheater(selctedmoviedetails);
			
		
//		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("ags") ) {
//			pvr(selctedmoviedetails);
//			
//		}
//		else if(selctedmoviedetails.getTheatername().equalsIgnoreCase("inox")) {
//			pvr(selctedmoviedetails);
//			
//		}
		
		
	}


	public MovieEntity[] gettheater( MovieEntity selctedmoviedetails ) {

		System.out.println("*******************" + selctedmoviedetails.getTheatername() + "**************");
		log.info(" ****************went inside selected theater  ");
		return movieservice.gettheater(selctedmoviedetails);
	}
	
//    public MovieEntity[] ags( MovieEntity selctedmoviedetails ) {
//
//		return movieservice.ags(selctedmoviedetails);
//	}
//
//    public MovieEntity[] inox( MovieEntity selctedmoviedetails ) {
//
//	return movieservice.inox(selctedmoviedetails);
//}
//    
    @PostMapping("/pushmoviedetails")
    public  String[][]  pushmoviedetails(@RequestBody MovieEntity selctedmoviedetails ) throws InterruptedException {
    	
    	return movieservice.pushmoviedetails(selctedmoviedetails);
    	
       }
    
    
    @PostMapping("/inserttheater")
	public TheaterEntity inserttheater(@RequestBody TheaterEntity  insertabletheater) {
			
    	movieservice.inserttheater(insertabletheater);
		
		 return null ;
	}
	
	@GetMapping("/getalltheaters")
	public TheaterEntity[] gettheaters() {
		
		System.out.println("********inside movie service controller***************");
		
		return movieservice.gettheaters();
		
	}
	
	@PostMapping("/selectedtheater")
	public MovieEntity[] selectedtheater(@RequestBody MovieEntity theaternameJson) {
		
	log.info("inside theater controller layer : " + theaternameJson.getTheatername());
		
    return	maptheater(theaternameJson);
	   	

	}
	
    @PostMapping("/ticketconfirmrequest")
    public String ticketconfirmrequest(@RequestBody SeatsEntity ticketrequest  ) {
    	
    	return movieservice.ticketconfirmrequest(ticketrequest);
    }
    
	
    
	
	
}
