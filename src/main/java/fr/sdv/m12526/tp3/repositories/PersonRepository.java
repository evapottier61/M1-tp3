package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Animal;
import fr.sdv.m12526.tp3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer>, PersonRepositoryCustom {
    public List<Person> findByLastnameLikeOrFirstnameLike(String lastName, String firstName);
    //select * from person where lastname like lastname or firstname like firstname

    public List<Person> findByAgeIsGreaterThanEqual(Integer age);

    //tp5

    @Query("from Person where age between :ageMin and :ageMax")
    public List<Person> findByAgeBetween(@Param("ageMin") Integer ageMin, @Param("ageMax") Integer ageMax);

    @Query("from Person where :animal member of animals")
    public List<Person> findByAnimalsContains(@Param("animal") Animal animal);

    //tp6
    @Modifying
    void deleteAllByFirstname(String firstname);
}

