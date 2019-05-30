package pl.polsl.bookstore.repository;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.OrderHistory;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.sql.Date;
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
    public void updateOrderHistory(long idUser, long idWarehouse, double purchasePrice,long quantity){
        Query query = (Query) entityManager.createQuery("UPDATE OrderHistory  SET id_book_warehouse=: idWarehouse, id_user= :idUser, date=:date, quantity= :quantity, purchase_price=:purchasePrice" +
                " WHERE id_user = :id");
        int updateQuery = query
                .setParameter("idWarehouse", idWarehouse)
                .setParameter("idUser", idUser)
                .setParameter("date", new java.sql.Date(System.currentTimeMillis()))
                .setParameter("quantity", quantity)
                .setParameter("purchasePrice", purchasePrice)
                .executeUpdate();
    }
}
