package com.ticketconfirmation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConfirmationEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long theaterid ;
	private String theatername;
	private String moviename ;
	private String movietime ;	
	private String seatnumber ;
	private String screen ;
	
	public ConfirmationEntity() {
		super();
	}

	public ConfirmationEntity(Long theaterid, String theatername, String moviename, String movietime, String seatnumber,
			String screen) {
		super();
		this.theaterid = theaterid;
		this.theatername = theatername;
		this.moviename = moviename;
		this.movietime = movietime;
		this.seatnumber = seatnumber;
		this.screen = screen;
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

	public String getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	
	
	
	
}
