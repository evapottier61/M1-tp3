package fr.sdv.m12526.tp3;

import fr.sdv.m12526.tp3.domain.Person;
import fr.sdv.m12526.tp3.repositories.AnimalRepository;
import fr.sdv.m12526.tp3.repositories.PersonRepository;
import fr.sdv.m12526.tp3.repositories.RoleRepository;
import fr.sdv.m12526.tp3.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SpeciesRepository speciesRepository;


    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Iterable<Person> persons = personRepository.findAll();
        for  (Person person : persons) {
            person.toString();
        }

        System.out.println(personRepository.findAll());
        System.out.println(personRepository.count());
        personRepository.deleteById(1);
        System.out.println(personRepository.count());
        System.out.println(roleRepository.findAll());

    }
}
