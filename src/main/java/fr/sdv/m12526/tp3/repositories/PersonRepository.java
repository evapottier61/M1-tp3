package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
}
