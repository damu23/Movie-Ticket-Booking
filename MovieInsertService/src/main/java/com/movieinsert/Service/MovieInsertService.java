package com.movieinsert.Service;

import java.util.List;

import com.movieinsert.Entity.MovieInsertEntity;
import com.movieinsert.Entity.TheaterEntity;

public interface MovieInsertService {

	MovieInsertEntity insertmovie(MovieInsertEntity insertablejson);

	List<MovieInsertEntity> getmoviesbytheatername(String theatername);

	List<MovieInsertEntity> getinsertedmovies();

	List<MovieInsertEntity> insertlistoftheaterandmovies(List<MovieInsertEntity> listoftheaterandmovies);

	List<TheaterEntity> getinsertedtheaters();

	TheaterEntity inserttheater(TheaterEntity theatername);


	

}
