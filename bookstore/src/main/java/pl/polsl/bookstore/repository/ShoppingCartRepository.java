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

    @Transactional
    public void updateShoppingCart(long idWarehouse,long idUser,int quantity){
        Query query = (Query) entityManager.createQuery("UPDATE ShoppingCart sh SET quantity = :quantity" +
                " WHERE id_book_warehouse = :id_warehouse AND id_user= :id_user");
        int updateQuery = query
                .setParameter("id_warehouse", idWarehouse)
                .setParameter("id_user", idUser)
                .setParameter("quantity" ,Long.valueOf(quantity) )
                .executeUpdate();

    }

    @Transactional
    public void deleteBookFromShoppingCart(long idWarehouse,long idUser){

         Query query = (Query) entityManager.createQuery("DELETE FROM ShoppingCart sh" +
                " WHERE id_book_warehouse = :id_warehouse AND id_user= :id_user");
        int deleteQuery = query
                .setParameter("id_warehouse", idWarehouse)
                .setParameter("id_user", idUser)
                .executeUpdate();

    }

    @Transactional
    public void deleteBooksFromShoppingCart(long idUser){
        Query query = (Query) entityManager.createQuery("DELETE FROM ShoppingCart sh" +
                " WHERE id_user= :id_user");
        int deleteQuery = query
                .setParameter("id_user", idUser)
                .executeUpdate();
    }

    @Transactional
    public void reduceQuantityWarehouse (long idWarehouse, long quantity){
        Query query = (Query) entityManager.createQuery("UPDATE Warehouse wh SET quantity = :quantity" +
                " WHERE id_book_warehouse = :id_warehouse ");
        int updateQuery = query
                .setParameter("id_warehouse", idWarehouse)
                .setParameter("quantity" ,Long.valueOf(quantity) )
                .executeUpdate();
    }
}
