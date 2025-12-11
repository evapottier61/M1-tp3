package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Animal;
import fr.sdv.m12526.tp3.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    public List<Animal> findAnimalsBySpecies(Species species);

    public List<Animal> findAnimalsByColorIsIn(List<String> colors);

    @Query("Select count(*) from Animal where sex = :sex")
    public Integer countAnimalsBySex(@Param("sex") String sex);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Person p" +
            "       JOIN p.animals a WHERE p.id = :personId")
    public Boolean findAnimalsByPersonId(@Param("personId") Integer personId);



}

//select true from Animal where Animal in (select Animal from Person where personId = :personId))
