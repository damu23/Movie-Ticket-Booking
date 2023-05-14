package com.movieinsert.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieinsert.Entity.MovieInsertEntity;
import com.movieinsert.Entity.TheaterEntity;
import com.movieinsert.Repository.MovieInserRepository;
import com.movieinsert.Repository.TheaterRepo;

@Service
public class MovieInsertServiceimpl  implements MovieInsertService{

	
	@Autowired
	MovieInserRepository movieinsertrepository;
	
	@Autowired
	TheaterRepo theaterrepo ;
	
	
	
	@Override
	public MovieInsertEntity insertmovie(MovieInsertEntity insertablejson) {

		return movieinsertrepository.save(insertablejson) ;
		
	}

	@Override
	public List<MovieInsertEntity> getmoviesbytheatername(String theatername) {
		
		return  movieinsertrepository.findBythetername(theatername);
		
		
	}

	@Override
	public List<MovieInsertEntity> getinsertedmovies() {

		return movieinsertrepository.findAll();
	}

	@Override
	public List<MovieInsertEntity> insertlistoftheaterandmovies(List<MovieInsertEntity> listoftheaterandmovies) {
		
		return movieinsertrepository.saveAll(listoftheaterandmovies);
	}

	@Override
	public TheaterEntity inserttheater(TheaterEntity theatername) {
		
		return theaterrepo.save(theatername);
	}

	
	
	@Override
	public List<TheaterEntity> getinsertedtheaters() {
		
		return  theaterrepo.findBygettheaters();
	}


	
	

}
