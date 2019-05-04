package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.BookFormat;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookFormatRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public BookFormatRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<BookFormat> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<BookFormat> theQuery =
                currentSession.createQuery("from BookFormat", BookFormat.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<BookFormat> bookFormat = theQuery.getResultList();

        // return the results
        return bookFormat;
    }
}
