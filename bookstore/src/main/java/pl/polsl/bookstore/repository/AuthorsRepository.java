package pl.polsl.bookstore.repository;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Authors;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuthorsRepository {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public AuthorsRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Transactional
    public List<Authors> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Authors> theQuery =
                currentSession.createQuery("from Authors", Authors.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Authors> authors = theQuery.getResultList();

        // return the results
        return authors;
    }
}
