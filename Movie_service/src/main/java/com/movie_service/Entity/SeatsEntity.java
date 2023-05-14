package com.movie_service.Entity;

public class SeatsEntity {

    private Long theaterid ;
	private String theatername;
	private String moviename ;
	private String movietime ;	
	private String seatnumber ;
	private String screen ;
	
	public SeatsEntity() {
		super();
	}
	
	public SeatsEntity(Long theaterid, String theatername, String moviename, String movietime) {
		super();
		this.theaterid = theaterid;
		this.theatername = theatername;
		this.moviename = moviename;
		this.movietime = movietime;
		
			
	}
	
	public SeatsEntity(Long theaterid, String theatername, String moviename, String movietime , String seatnumber, String screen) {
		super();
		this.theaterid = theaterid;
		this.theatername = theatername;
		this.moviename = moviename;
		this.movietime = movietime;
		this.screen = screen ;	
		this.seatnumber = seatnumber ;
			
	}

	public Long getTheaterid() {
		return theaterid;
	}

	public void setTheaterid(Long theaterid) {
		this.theaterid = theaterid;
	}

	public String getTheatername() {
		return theatername;
	}

	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getMovietime() {
		return movietime;
	}

	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	} 
	
}