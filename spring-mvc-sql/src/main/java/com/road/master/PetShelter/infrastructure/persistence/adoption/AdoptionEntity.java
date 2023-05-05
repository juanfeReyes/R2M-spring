package com.road.master.PetShelter.infrastructure.persistence.adoption;

import com.road.master.PetShelter.infrastructure.persistence.pet.PetEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("adoption")
public class AdoptionEntity {

  @Id
  private String id;

  @MappedCollection(idColumn = "id", keyColumn = "pet_id")
  private PetEntity pet;

  @MappedCollection(idColumn = "id", keyColumn = "adopter_id")
  private AdopterEntity adopterEntity;

  private LocalDate adoptionDate;

  private String description;
}
