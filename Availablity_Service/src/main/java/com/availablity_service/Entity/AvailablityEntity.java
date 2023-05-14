package com.availablity_service.Entity;

import javax.persistence.*;

@Entity
public class AvailablityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String theatername;
	private String moviename;
	private String movietime ;
	private String seatnumber ;
	private String screen ;
	
	public AvailablityEntity() {
		super();
	}
	
	
	public AvailablityEntity(Long id, String theatername, String moviename, String movietime, String seatnumber,
			String screen) {
		super();
		this.id = id;
		this.theatername = theatername;
		this.moviename = moviename;
		this.movietime = movietime;
		this.seatnumber = seatnumber;
		this.screen = screen;
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
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	
}
