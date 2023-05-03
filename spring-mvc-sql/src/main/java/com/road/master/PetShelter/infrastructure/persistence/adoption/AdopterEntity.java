package com.road.master.PetShelter.infrastructure.persistence.adoption;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("adopter")
public class AdopterEntity {

  @Id
  private String id;

  private String name;

  private String lastname;

  private String address;

}
