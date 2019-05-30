package pl.polsl.bookstore.repository;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.OrderHistory;
import pl.polsl.bookstore.entity.Warehouse;
import pl.polsl.bookstore.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderHistoryRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public OrderHistoryRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<OrderHistory> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<OrderHistory> theQuery =
                currentSession.createQuery("from OrderHistory", OrderHistory.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<OrderHistory> orderHistory = theQuery.getResultList();

        // return the results
        return orderHistory;
    }

    @Transactional
    public void addOrderHistory(Warehouse warehouse,Users user, long quantity, double purchasePrice){
        java.sql.Date date =new java.sql.Date(System.currentTimeMillis());
        OrderHistory orderHistory= new OrderHistory(warehouse, user,date, quantity, purchasePrice);
        this.entityManager.persist(orderHistory);
    }
}
