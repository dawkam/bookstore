package pl.polsl.bookstore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class OpinionsRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public OpinionsRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
}
