	package com.availablity_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.availablity_service.Entity.AvailablityEntity;
import com.availablity_service.Repository.AvailablityRepo;


@Service
public class AvailablityServiceimpl implements AvailablityService{

	@Autowired
	AvailablityRepo availablityrepo;
	
	
	@Override
	public List<AvailablityEntity> pvroccupied(AvailablityEntity putdetails) {
		
		String theatername = putdetails.getTheatername();
		System.out.println("****************theatername******************" + theatername);
		
		String movietime = putdetails.getMovietime();
		System.out.println("*******************movietime********************" + movietime);
		
		String screen = putdetails.getScreen();
		
		
		return availablityrepo.pvroccupied(theatername, movietime, screen);
	}
	
	@Override
	public List<AvailablityEntity> agsoccupied(AvailablityEntity putdetails) {

		String theatername = putdetails.getTheatername();
		System.out.println("****************theatername******************" + theatername);
		
		String movietime = putdetails.getMovietime();
		System.out.println("*******************movietime********************" + movietime);
		
		String screen = putdetails.getScreen();
		System.out.println("***********screen*******************" + screen );
		
		return availablityrepo.agsoccupied(theatername, movietime, screen);
		
	}

	@Override
	public List<AvailablityEntity> inoxoccupied(AvailablityEntity putdetails) {
		
		
        System.out.println("*********into inox service layer *****");
		
		String theatername = putdetails.getTheatername();
		System.out.println("****************theatername******************" + theatername);
		
		String movietime = putdetails.getMovietime();
		System.out.println("*******************movietime********************" + movietime);
		
		String screen = putdetails.getScreen();
		System.out.println("***********screen*******************" + screen );
		
		return availablityrepo.inoxoccupied(theatername, movietime, screen);
	}

	@Override
	public AvailablityEntity insertbooked(AvailablityEntity booking) {
		return availablityrepo.save(booking);
		
	}

	@Override
	public List<AvailablityEntity> bulkinsertbooking(List<AvailablityEntity> bulkinserts) {
		
		return availablityrepo.saveAll(bulkinserts);
	}

	@Override
	public List<AvailablityEntity> getallinsserted() {
		
		return availablityrepo.findAll();
	}





















}
