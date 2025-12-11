package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species,Integer> {

    public Species findFirstByCommonNameLike(String name);

    public List<Species> findByLatinNameContainsIgnoreCase(String name);

    @Query("from Species order by commonName")
    public List<Species> findAllOrderByCommonName();

    @Query("from Species where commonName like :commonName")
    public List<Species> findAllByCommonNameLike(@Param("commonName") String commonName);

}
