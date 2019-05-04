package pl.polsl.bookstore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class WarehouseRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public WarehouseRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
}
