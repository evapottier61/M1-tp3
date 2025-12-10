package fr.sdv.m12526.tp3.boot;

import fr.sdv.m12526.tp3.domain.Person;
import fr.sdv.m12526.tp3.repositories.AnimalRepository;
import fr.sdv.m12526.tp3.repositories.PersonRepository;
import fr.sdv.m12526.tp3.repositories.RoleRepository;
import fr.sdv.m12526.tp3.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final SpeciesRepository speciesRepository;
    private final AnimalRepository animalRepository;

    public Startup(PersonRepository personRepository,
                   RoleRepository roleRepository, SpeciesRepository speciesRepository, AnimalRepository animalRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.speciesRepository = speciesRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            personRepository.findAll().forEach(System.out::println);
            roleRepository.findAll().forEach(System.out::println);
            speciesRepository.findAll().forEach(System.out::println);
            animalRepository.findAll().forEach(System.out::println);
    }
}
