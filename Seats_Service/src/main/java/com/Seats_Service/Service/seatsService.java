package com.Seats_Service.Service;

import com.Seats_Service.Entity.SeatsEntity;

public interface seatsService {

	String[][] pvrseats(SeatsEntity moviedetails);

	String[][] agsseats(SeatsEntity agsbody);

	String[][] inoxseats(SeatsEntity inoxbody);

	String confirmPVRticket(SeatsEntity pvrconfirmrequest);

	String confirmAGSticket(SeatsEntity agsconfirmrequest);

	String confirmINOXticket(SeatsEntity inoxconfirmrequest);





//	public void getpvrseat(SeatsEntity pvr);
	

	
	
	
	
	
	
}
