package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Books;
import pl.polsl.bookstore.entity.Opinions;
import pl.polsl.bookstore.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OpinionsRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public OpinionsRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Opinions> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Opinions> theQuery =
                currentSession.createQuery("from Opinions", Opinions.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Opinions> opinions = theQuery.getResultList();

        // return the results
        return opinions;
    }

    @Transactional
    public void addOpinion(Users user,Books book, String opinion) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Opinions> theQuery =
                currentSession.createQuery("from Opinions", Opinions.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Opinions> opinions = theQuery.getResultList();



    }

}
