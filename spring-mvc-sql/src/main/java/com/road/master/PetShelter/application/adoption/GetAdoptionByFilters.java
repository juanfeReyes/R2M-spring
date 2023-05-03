package com.road.master.PetShelter.application.adoption;

import com.road.master.PetShelter.infrastructure.persistence.adoption.AdoptionEntity;
import com.road.master.PetShelter.infrastructure.persistence.adoption.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAdoptionByFilters {

  private final AdoptionRepository adoptionRepository;

  @Autowired
  public GetAdoptionByFilters(AdoptionRepository adoptionRepository) {
    this.adoptionRepository = adoptionRepository;
  }

  public Page<AdoptionEntity> execute(){
    return adoptionRepository.findAll(Pageable.ofSize(5));
  }
}
