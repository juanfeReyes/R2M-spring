package com.road.master.PetShelter.infrastructure.persistence;

import com.road.master.PetShelter.infrastructure.persistence.adoption.AdoptionRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                AdoptionRepository.class})
})
@EnableJdbcRepositories(includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                AdoptionRepository.class})
})
public class PersistenceConfig {
}
