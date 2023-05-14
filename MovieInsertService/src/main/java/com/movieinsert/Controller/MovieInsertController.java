	package com.movieinsert.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieinsert.Entity.MovieInsertEntity;
import com.movieinsert.Entity.TheaterEntity;
import com.movieinsert.Service.MovieInsertService;

@RestController
@RequestMapping("/insertmoviesfortheater")
public class MovieInsertController {

	@Autowired
	MovieInsertService movieinsertservice;

	@PostMapping("/insertmovies")
	public MovieInsertEntity insertmovie(@RequestBody MovieInsertEntity insertablejson) {

		return movieinsertservice.insertmovie(insertablejson);

	}

	@PostMapping("/insertlistoftheaterandmovies")
	public List<MovieInsertEntity> listoftheaterandmovies(@RequestBody List<MovieInsertEntity> listoftheaterandmovies) {

	return 	movieinsertservice.insertlistoftheaterandmovies(listoftheaterandmovies);
		

	}

	@GetMapping("/getmoviesbytheatername/{theatername}")
	public ResponseEntity<List<MovieInsertEntity>> getmoviesbytheatername(@PathVariable("theatername") String theatername) {

		System.out.println("controller" + theatername);
		List<MovieInsertEntity> mve = movieinsertservice.getmoviesbytheatername(theatername);

		return new ResponseEntity<List<MovieInsertEntity>>(mve, HttpStatus.OK);

	}

	@GetMapping("/getinsertedmovies")
	public List<MovieInsertEntity> getinsertedmovies() {
		return movieinsertservice.getinsertedmovies();
	}
	
	
	@PostMapping("/inserttheater")
	public TheaterEntity inserttheater(@RequestBody TheaterEntity theatername ) {
		
		return movieinsertservice.inserttheater(theatername);
		
	}
	
	@GetMapping("getinsertedtheaters")
	public List<TheaterEntity> getinsertedtheaters (){
		return movieinsertservice.getinsertedtheaters();
	}

}
