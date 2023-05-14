package com.movieinsert.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieinsert.Entity.MovieInsertEntity;

@Repository
public interface MovieInserRepository extends JpaRepository<MovieInsertEntity, Long>{

	@Query("from MovieInsertEntity where theatername=?1")
	List<MovieInsertEntity> findBythetername(String theatername);
	
	
}
