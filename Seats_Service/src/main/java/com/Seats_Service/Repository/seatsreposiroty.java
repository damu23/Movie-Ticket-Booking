package com.Seats_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Seats_Service.Entity.SeatsEntity;

public interface seatsreposiroty  extends JpaRepository<SeatsEntity, Long>{

}
