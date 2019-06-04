package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Books;

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
    public Books findBookById(String id) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Books> theQuery =
                currentSession.createQuery("select b from Books b where  b.idBook LIKE concat('%', :id, '%')", Books.class).setParameter("id", id);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Books> books = theQuery.getResultList();

        // return the results
        return books.get(0);
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
    public List<Books> searchByAuthor(boolean isAscending) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        if(isAscending){
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT ba.booksB FROM BookAuthor ba order by ba.authorsB.surname ASC");
            return theQuery.getResultList();
        }
        else{
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT ba.booksB FROM BookAuthor ba order by ba.authorsB.surname DESC");
            return theQuery.getResultList();
        }
    }

    @Transactional
    public List<Books> searchByAuthorName(boolean isAscending) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        if(isAscending){
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT ba.booksB FROM BookAuthor ba order by ba.authorsB.firstName ASC");
            return theQuery.getResultList();
        }
        else{
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT ba.booksB FROM BookAuthor ba order by ba.authorsB.firstName DESC");
            return theQuery.getResultList();
        }
    }

    @Transactional
    public List<Books> searchByTitle(boolean isAscending) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        if(isAscending){
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT ba.booksB FROM BookAuthor ba order by ba.booksB.title ASC");
            return theQuery.getResultList();
        }
        else{
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT ba.booksB FROM BookAuthor ba order by ba.booksB.title DESC");
            return theQuery.getResultList();
        }
    }

    @Transactional
    public List<Books> searchByPrice(boolean isAscending) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        if(isAscending){
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT w.booksW FROM Warehouse w where w.bookFormatW.bookFormat='książka' order by w.price ASC");      //from odnosi sie do klasy nie do tabeli
            return theQuery.getResultList();
        }
        else{
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT w.booksW FROM Warehouse w where w.bookFormatW.bookFormat='książka' order by w.price DESC");      //from odnosi sie do klasy nie do tabeli
            return theQuery.getResultList();
        }
    }

    @Transactional
    public List<Books> searchByPriceEbook(boolean isAscending) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        if(isAscending){
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT w.booksW FROM Warehouse w where w.bookFormatW.bookFormat='e-book' order by w.price ASC");      //from odnosi sie do klasy nie do tabeli
            return theQuery.getResultList();
        }
        else{
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT w.booksW FROM Warehouse w where w.bookFormatW.bookFormat='e-book' order by w.price DESC");      //from odnosi sie do klasy nie do tabeli
            return theQuery.getResultList();
        }
    }

    @Transactional
    public List<Books> searchByPriceAudiobook(boolean isAscending) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        if(isAscending){
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT w.booksW FROM Warehouse w where w.bookFormatW.bookFormat='audiobook' order by w.price ASC");      //from odnosi sie do klasy nie do tabeli
            return theQuery.getResultList();
        }
        else{
            Query<Books> theQuery =
                    currentSession.createQuery("SELECT w.booksW FROM Warehouse w where w.bookFormatW.bookFormat='audiobook' order by w.price DESC");      //from odnosi sie do klasy nie do tabeli
            return theQuery.getResultList();
        }
    }
}
