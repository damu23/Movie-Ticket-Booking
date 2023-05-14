package com.movie_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.movie_service.Entity.MovieEntity;

public class MIEtest {
	
	@Autowired
	static
	RestTemplate resttemplate;
	
	public static void main(String[] args) {
		
		 @SuppressWarnings("unchecked")
		List<MovieEntity> mie =  (List<MovieEntity>) resttemplate.getForObject
					("http://localhost:8120/insertmoviesfortheater/getmoviesbytheatername/pvr",
							MovieEntity.class) ;
		 
		 for(MovieEntity mieitr : mie) {
			 System.out.println(mieitr.getMoviename());
			 System.out.println(mieitr.getMoviename());
		 }
		
		
	}

}
