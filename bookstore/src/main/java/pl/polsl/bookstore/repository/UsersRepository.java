package pl.polsl.bookstore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.polsl.bookstore.entity.Users;

import javax.persistence.EntityManager;

@Repository
public class UsersRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public UsersRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
}
