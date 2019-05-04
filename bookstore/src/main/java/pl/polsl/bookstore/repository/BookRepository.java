package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Books;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public BookRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Books> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Books> theQuery =
                currentSession.createQuery("from Books", Books.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Books> books = theQuery.getResultList();

        // return the results
        return books;
    }
}
