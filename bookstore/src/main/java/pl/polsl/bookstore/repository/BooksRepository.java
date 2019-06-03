package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Books;
import pl.polsl.bookstore.entity.Opinions;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.*;

@Repository
public class BooksRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public BooksRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Books> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Books> theQuery =
                currentSession.createQuery("from Books b order by b.title", Books.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Books> books = theQuery.getResultList();

        // return the results
        return books;
    }

    @Transactional
    public List<Books> booksSearch(String searchTerm) {
        if(!searchTerm.equals(""))
        {
            // get the current hibernate session
            Session currentSession = entityManager.unwrap(Session.class);

            // create a query
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT b FROM Books b where b.title LIKE concat('%', :searchTerm, '%') order by b.title").setParameter("searchTerm", searchTerm);      //from odnosi sie do klasy nie do tabeli

            // execute query and get result list
            List<Books> books = theQuery.getResultList();
            // return the results
            return books;
        }
       else return findAll();
    }

    @Transactional
    public void addOpinion(Opinions opinion){
        this.entityManager.persist(opinion);
    }


}
