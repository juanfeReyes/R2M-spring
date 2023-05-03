package com.road.master.PetShelter.infrastructure.persistence.adoption;

import org.springframework.data.domain.Page;

public interface ICustomAdoptionRepository {

  Page<AdoptionEntity> findAllAdoptions();
}
