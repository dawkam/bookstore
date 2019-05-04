package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.ShoppingCart;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ShoppingCartRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public ShoppingCartRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<ShoppingCart> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<ShoppingCart> theQuery =
                currentSession.createQuery("from ShoppingCart", ShoppingCart.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<ShoppingCart> shoppingCart = theQuery.getResultList();

        // return the results
        return shoppingCart;
    }
}
