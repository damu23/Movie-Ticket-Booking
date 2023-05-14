package com.movieinsert.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movieinsert.Entity.TheaterEntity;

public interface TheaterRepo extends JpaRepository<TheaterEntity, Long> {

	
	@Query(value = "select * from theater_entity"  , nativeQuery = true)
	List<TheaterEntity> findBygettheaters();
	
	
}
