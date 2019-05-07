package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.BookAuthor;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookAuthorRepository {
    private EntityManager entityManager;

    @Autowired
    public BookAuthorRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<BookAuthor> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<BookAuthor> theQuery =
                currentSession.createQuery("from BookAuthor", BookAuthor.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<BookAuthor> bookAuthors = theQuery.getResultList();

        // return the results
        return bookAuthors;
    }

    @Transactional
    public List<BookAuthor> bookTitleSearch(String searchTerm) {
        if(!searchTerm.equals(""))
        {
            // get the current hibernate session
            Session currentSession = entityManager.unwrap(Session.class);

            // create a query
            Query<BookAuthor> theQuery =
                    currentSession.createQuery("SELECT ba FROM BookAuthor ba " +
                            "where ba.booksB.title " +
                            "LIKE concat('%', :searchTerm, '%') or ba.authorsB.firstName "+
                            "LIKE concat('%', :searchTerm, '%') order by ba.booksB.title")
                                    .setParameter("searchTerm", searchTerm);      //from odnosi sie do klasy nie do tabeli

            // execute query and get result list
            List<BookAuthor> bookAuthor = theQuery.getResultList();
            // return the results
            return bookAuthor;
        }
        else return findAll();
    }
}
