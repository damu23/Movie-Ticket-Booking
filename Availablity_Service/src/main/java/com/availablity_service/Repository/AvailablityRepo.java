package com.availablity_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.availablity_service.Entity.AvailablityEntity;

@Repository
public interface AvailablityRepo extends JpaRepository<AvailablityEntity, Integer>{

	
	
	
	
	@Query("from AvailablityEntity where theatername=?1 and movietime=?2  and screen=?3")
    List<AvailablityEntity> pvroccupied(String theatername , String movietime , String screen);
	
	
	@Query("from AvailablityEntity where theatername=?1 and movietime=?2  and screen=?3")
    List<AvailablityEntity> agsoccupied(String theatername , String movietime , String screen);
	
	@Query("from AvailablityEntity where theatername=?1 and movietime=?2  and screen=?3")
    List<AvailablityEntity> inoxoccupied(String theatername , String movietime , String screen);
	
	

	
}
