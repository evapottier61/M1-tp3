package fr.sdv.m12526.tp3.boot;

import fr.sdv.m12526.tp3.domain.Animal;
import fr.sdv.m12526.tp3.domain.Person;
import fr.sdv.m12526.tp3.domain.Species;
import fr.sdv.m12526.tp3.repositories.AnimalRepository;
import fr.sdv.m12526.tp3.repositories.PersonRepository;
import fr.sdv.m12526.tp3.repositories.RoleRepository;
import fr.sdv.m12526.tp3.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
        /*roleRepository.findAll().forEach(System.out::println);
        speciesRepository.findAll().forEach(System.out::println);
        animalRepository.findAll().forEach(System.out::println);*/


        // Species
        System.out.println(speciesRepository.findFirstByCommonNameLike("Chat"));
        List<Species> species = speciesRepository.findByLatinNameContainsIgnoreCase("catus");
        for (Species species1 : species) {
            System.out.println(species1);
        }

        // Person
        List<Person> people = personRepository.findByLastnameLikeOrFirstnameLike("%Nero%", "%Paul%");
        for (Person person : people) {
            System.out.println(person);
        }

        List<Person> people1 = personRepository.findByAgeIsGreaterThanEqual(45);
        for (Person person : people1) {
            System.out.println(person);
        }

        //Animal
        Species s = speciesRepository.findFirstByCommonNameLike("Chat");
        List<Animal> animals = animalRepository.findAnimalsBySpecies(s);
        for (Animal animal : animals) {
            System.out.println(animal);
        }

        List<String> colors = List.of("Noir", "Roux");
        List<Animal> animals1 = animalRepository.findAnimalsByColorIsIn(colors);
        for (Animal animal : animals1) {
            System.out.println(animal);
        }

    }
}
