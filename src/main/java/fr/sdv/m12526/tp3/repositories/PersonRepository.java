package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    public List<Person> findByLastnameLikeOrFirstnameLike(String lastName, String firstName);
    //select * from person where lastname like lastname or firstname like firstname

    public List<Person> findByAgeIsGreaterThanEqual(Integer age);
}
