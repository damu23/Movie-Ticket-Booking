package com.movie_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_service.Entity.MovieEntity;
import com.movie_service.Entity.TheaterEntity;

public interface TheaterRepo extends JpaRepository<TheaterEntity, Long> {

	@Query(value = "select theaterid,theatername from theater_entity"  , nativeQuery = true)
	List<TheaterEntity> findBygettheaters();

}
