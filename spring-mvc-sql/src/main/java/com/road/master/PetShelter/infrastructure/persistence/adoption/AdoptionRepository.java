package com.road.master.PetShelter.infrastructure.persistence.adoption;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends PagingAndSortingRepository<AdoptionEntity, String>, ICustomAdoptionRepository {
}
