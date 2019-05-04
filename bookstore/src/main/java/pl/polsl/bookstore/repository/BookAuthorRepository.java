package pl.polsl.bookstore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BookAuthorRepository {
    private EntityManager entityManager;

    @Autowired
    public BookAuthorRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
}
