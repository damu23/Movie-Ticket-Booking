package com.ticketconfirmation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketconfirmation.Entity.ConfirmationEntity;

public interface ConfirmationRepo  extends JpaRepository<ConfirmationEntity, Long>{

}
