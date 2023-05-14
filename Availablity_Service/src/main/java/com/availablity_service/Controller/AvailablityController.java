package com.availablity_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.availablity_service.Entity.AvailablityEntity;
import com.availablity_service.Service.AvailablityService;

@RestController
@RequestMapping("/availablitychecker")
public class AvailablityController {


	List<AvailablityEntity>  Pvroccupied = null ; 
	
	List<AvailablityEntity> Agsoccupied = null ;
	
	List<AvailablityEntity> Inoxoccupied = null ;
	
	@Autowired
	AvailablityService availablityservice ;
	
	
	@PostMapping("/pvroccupied")
	public List<AvailablityEntity> pvroccupied(@RequestBody AvailablityEntity putdetails) {
		
		Pvroccupied = availablityservice.pvroccupied(putdetails);
		
		return  null ;
	}
	
	@GetMapping("/getpvroccupied")
	public List<AvailablityEntity> getPvroccupied() {
		return Pvroccupied ;
	}
	
	@PostMapping("/agsoccupied")
	public List<AvailablityEntity> agsoccupied(@RequestBody AvailablityEntity putdetails) {
		
		Agsoccupied = availablityservice.agsoccupied(putdetails);
		
		return  null ;
	}
	
	@GetMapping("/getagsoccupied")
	public List<AvailablityEntity> getagsoccupied() {
		return Agsoccupied ;
	}
	
	@PostMapping("/inoxoccupied")
	public List<AvailablityEntity> inoxoccupied(@RequestBody AvailablityEntity putdetails) {
		
//		return availablityservice.inoxoccupied(putdetails); 
		
	 
		List<AvailablityEntity> inoxoccupiedtemp = availablityservice.inoxoccupied(putdetails);
		
//		System.out.println("*****8before inox itr");
//		for( AvailablityEntity inxoc  : inoxoccupiedtemp) {
//			System.out.println(inxoc.getMoviename());
//			System.out.println(inxoc.getScreen());
//			System.out.println(inxoc.getTheatername());
//			
//		}
		
		
		
		Inoxoccupied = inoxoccupiedtemp ;
		
		
	return null ; 
		
		
	}
	
	@GetMapping("/getinoxoccupied")
	public List<AvailablityEntity> getinoxavailablility() {
		
//		System.out.println("*****before inox itr");
//		for( AvailablityEntity inxoc  : Inoxoccupied) {
//			System.out.println(inxoc.getMoviename());
//			System.out.println(inxoc.getScreen());
//			System.out.println(inxoc.getTheatername());
//			
//		}
		
		
		
		return Inoxoccupied ;
	}
		
	////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/insertbooking")
	public AvailablityEntity insertbooked(@RequestBody AvailablityEntity booking) {
		
		
		
		System.out.println("into avilty contorllrer");
		System.out.println(booking.getTheatername());
		System.out.println(booking.getMoviename());
		System.out.println(booking.getMovietime());
		System.out.println(booking.getScreen());
		
		
	return 	availablityservice.insertbooked(booking);
		
	}
	
	@PostMapping("/bulkinsertbooking")
	public List<AvailablityEntity> bulkinsertbooking(@RequestBody List<AvailablityEntity> bulkinserts){
		
			return availablityservice.bulkinsertbooking(bulkinserts);

	}
	
	@GetMapping("/getallinsserted")
	public List<AvailablityEntity> getallinsserted(){
	 return	availablityservice.getallinsserted();
	}
	

	
	

}
