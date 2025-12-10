package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal,Integer> {
}
