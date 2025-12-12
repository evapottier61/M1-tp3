package fr.sdv.m12526.tp3.repositories;

import fr.sdv.m12526.tp3.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void deletePeopleWithoutAnimals() {
        String jpql = "DELETE FROM Person p WHERE p.animals IS EMPTY";
        Query query = em.createQuery(jpql);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void createManyPeople(int x) {
        Random rand = new Random();
        for(int i = 0; i < x; i++){
            Person p = new Person();
            p.setFirstname("firstname"+i);
            p.setLastname("lastname"+i);
            p.setAge(i);
            p.setLogin("login"+rand.nextInt(8521048));
            p.setMdp("mdp"+i);
            p.setActive((byte) 0);
            em.persist(p);
        }
    }
}
