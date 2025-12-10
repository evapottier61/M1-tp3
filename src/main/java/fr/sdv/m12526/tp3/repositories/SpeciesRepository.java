package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species,Integer> {
}
