package com.road.master.PetShelter.infrastructure.api.adoption;

import com.road.master.PetShelter.application.adoption.GetAdoptionByFilters;
import com.road.master.PetShelter.infrastructure.persistence.adoption.AdoptionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adoption")
@Tag(name = "Adoption")
@SecurityRequirement(name = "basicAuth")
public class GetAdoptionByFiltersController {

  private final GetAdoptionByFilters getAdoptionByFilters;

  @Autowired
  public GetAdoptionByFiltersController(GetAdoptionByFilters getAdoptionByFilters) {
    this.getAdoptionByFilters = getAdoptionByFilters;
  }

  @Operation(summary = "Get adoption by filters", security = {@SecurityRequirement(name = "OAuthScheme")})
  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasRole('WRITE')")
  public Page<AdoptionEntity> getAdoptionsByFilter(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "4") int limit){
    return getAdoptionByFilters.execute();
  }
}
