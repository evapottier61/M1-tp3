package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Animal;
import fr.sdv.m12526.tp3.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    public List<Animal> findAnimalsBySpecies(Species species);

    public List<Animal> findAnimalsByColorIsIn(List<String> colors);

}
