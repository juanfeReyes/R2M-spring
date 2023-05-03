package com.road.master.PetShelter.infrastructure.persistence.adoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdoptionRepositoryImpl implements ICustomAdoptionRepository{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public AdoptionRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Page<AdoptionEntity> findAllAdoptions() {
    return null;
  }
}
