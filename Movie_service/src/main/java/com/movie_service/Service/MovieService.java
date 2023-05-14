package com.movie_service.Service;

import java.util.List;

import com.movie_service.Entity.MovieEntity;
import com.movie_service.Entity.SeatsEntity;
import com.movie_service.Entity.TheaterEntity;


public interface MovieService {

	MovieEntity[] gettheater(MovieEntity selctedmoviedetails);

//	MovieEntity[] ags(MovieEntity selctedmoviedetails);
//
//	MovieEntity[] inox(MovieEntity selctedmoviedetails);

	String[][] pushmoviedetails(MovieEntity selctedmoviedetails) throws InterruptedException;

	TheaterEntity inserttheater(TheaterEntity insertabletheater);

	TheaterEntity[] gettheaters();

	String ticketconfirmrequest(SeatsEntity ticketrequest);


	


	

	




	

}
