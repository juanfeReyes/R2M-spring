package com.road.master.PetShelter.infrastructure.persistence.adoption;

import com.road.master.PetShelter.infrastructure.persistence.pet.PetEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table("adoption")
public class AdoptionEntity {

  @Id
  private String id;

  @MappedCollection(idColumn = "id")
  private Set<PetEntity> pet;

  @MappedCollection(idColumn = "id")
  private Set<AdopterEntity> adopterEntity;

  private LocalDate adoptionDate;

  private String description;
}
