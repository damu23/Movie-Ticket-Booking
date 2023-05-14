package com.Seats_Service.Entity;

import javax.persistence.*;


public class AvailablityEntity {


	private Long id ;
	private String theatername;
	private String moviename;
	private String movietime ;
	private String seatnumber ;
	private int seatstatus ;
	
	public AvailablityEntity() {
		super();
	}

	public AvailablityEntity(Long id, String theatername, String moviename, String movietime, String seatnumber,int seatstatus) {
		super();
		this.id = id;
		this.theatername = theatername;
		this.moviename = moviename;
		this.movietime = movietime;
		this.seatnumber = seatnumber;
		this.seatstatus = seatstatus ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getSeatstatus() {
		return seatstatus;
	}

	public void setSeatstatus(int seatstatus) {
		this.seatstatus = seatstatus;
	}
	
	
	
	
	
	
	
}
