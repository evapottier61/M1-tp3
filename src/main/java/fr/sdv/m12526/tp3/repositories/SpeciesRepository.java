package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species,Integer> {

    public Species findFirstByCommonNameLike(String name);

    public List<Species> findByLatinNameContainsIgnoreCase(String name);
}
