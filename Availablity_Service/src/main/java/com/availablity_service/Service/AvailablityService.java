package com.availablity_service.Service;

import java.util.List;

import com.availablity_service.Entity.AvailablityEntity;

public interface AvailablityService {



	AvailablityEntity insertbooked(AvailablityEntity booking);



	List<AvailablityEntity> bulkinsertbooking(List<AvailablityEntity> bulkinserts);

	List<AvailablityEntity> getallinsserted();

	List<AvailablityEntity> pvroccupied(AvailablityEntity putdetails);

	List<AvailablityEntity> agsoccupied(AvailablityEntity putdetails);

	List<AvailablityEntity> inoxoccupied(AvailablityEntity putdetails);




	

}
