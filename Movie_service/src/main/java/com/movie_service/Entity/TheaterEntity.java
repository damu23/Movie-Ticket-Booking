package com.movie_service.Entity;

import javax.persistence.*;

@Entity
public class TheaterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long theaterid ;
	private String theatername ;
	
	public TheaterEntity() {
		super();
	}

	public TheaterEntity(Long theaterid, String theatername) {
		super();
		this.theaterid = theaterid;
		this.theatername = theatername;
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
	
	
	
}
