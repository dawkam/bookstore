package pl.polsl.bookstore.repository;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.OrderHistory;
import pl.polsl.bookstore.entity.Warehouse;
import pl.polsl.bookstore.entity.Users;
import pl.polsl.bookstore.profit.ProfitPerAuthor;
import pl.polsl.bookstore.profit.ProfitPerBook;
import pl.polsl.bookstore.profit.ProfitPerMonth;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
    public List<OrderHistory> findByUserId(String UserId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<OrderHistory> theQuery =
                currentSession.createQuery("select o from OrderHistory o where  o.usersOr LIKE concat('%', :id, '%') order by  o.idOrderHistory DESC", OrderHistory.class).setParameter("id", UserId);      //from odnosi sie do klasy nie do tabeli

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

    @Transactional
    public List<ProfitPerMonth> getProfitPerMonth ()
    {

        Query query = (Query) entityManager.createNativeQuery(
                "Select r.y , r.m ,sum(r.p) " +
                "                From " +
                "                (Select  year(oh.date) as y ,month(oh.date) as m, wh.id_book_warehouse as id_book_wh ,sum(oh.purchase_price)- (wh.purchase_price * sum(oh.quantity)) as p" +
                "               From  order_history oh, warehouse wh" +
                        "       where  oh.id_book_warehouse=wh.id_book_warehouse " +
                "               group by y, m , oh.id_book_warehouse" +
                "               order by y desc, m desc) as r" +
                "        Group by r.y, r.m" );


        List<Object[]> tmp=query.getResultList();
        List<ProfitPerMonth> result = new ArrayList<ProfitPerMonth>();
        for(Object[] tmpp : tmp){
           result.add(new ProfitPerMonth((int)tmpp[0],(int)tmpp[1],((BigDecimal)tmpp[2]).floatValue()));
        }

            return result;
    }

    @Transactional
    public List<ProfitPerMonth> getProfitPerMonth (long yearF,long monthF,long yearT,long monthT)
    {

        Query query = (Query) entityManager.createNativeQuery(
                "Select r.y , r.m ,sum(r.p) " +
                        "                From " +
                        "                (Select  year(oh.date) as y ,month(oh.date) as m, wh.id_book_warehouse as id_book_wh ,sum(oh.purchase_price)- (wh.purchase_price * sum(oh.quantity)) as p" +
                        "               From  order_history oh, warehouse wh" +
                        "       where  oh.id_book_warehouse=wh.id_book_warehouse " +
                        "               group by y, m , oh.id_book_warehouse" +
                        "               order by y desc, m desc) as r" +
                        " Where r.y Between " + yearF +" and " + yearT + " and "+
                        "r.m Between  "+ monthF + " and " + monthT +
                        "        Group by r.y, r.m" );


        List<Object[]> tmp=query.getResultList();
        List<ProfitPerMonth> result = new ArrayList<ProfitPerMonth>();
        for(Object[] tmpp : tmp){
            result.add(new ProfitPerMonth((int)tmpp[0],(int)tmpp[1],((BigDecimal)tmpp[2]).floatValue()));
        }

        return result;
    }

    @Transactional
    public List<ProfitPerBook> getProfitPerBook ()
    {

        Query query = (Query) entityManager.createNativeQuery(
                "Select  b.title, sum(p)" +
                        "From(" +
                        "            Select wh.id_book as id_book ,sum(oh.purchase_price)- (wh.purchase_price * sum(oh.quantity)) as p " +
                        "From  order_history oh, warehouse wh " +
                        "where  oh.id_book_warehouse=wh.id_book_warehouse " +
                        "group by wh.id_book, oh.id_book_warehouse" +
                        ") as ppb , books as b " +
                        "where ppb.id_book = b.id_book " +
                        "group by ppb.id_book" );


        List<Object[]> tmp=query.getResultList();
        List<ProfitPerBook> result = new ArrayList<ProfitPerBook>();
        for(Object[] tmpp : tmp){
            result.add(new ProfitPerBook(tmpp[0].toString(),((BigDecimal)tmpp[1]).floatValue()));
        }

        return result;
    }
    @Transactional
    public List<ProfitPerAuthor> getProfitPerAuthor ()
    {

        Query query = (Query) entityManager.createNativeQuery(
                "Select a.first_name,a.surname, sum(profit_per_book) " +
                        "From( " +
                        " Select  b.id_book, sum(profit) as profit_per_book " +
                        " From( " +
                        " Select wh.id_book as id_book ,sum(oh.purchase_price)- (wh.purchase_price * sum(oh.quantity)) as profit " +
                        " From  order_history oh, warehouse wh " +
                        " where  oh.id_book_warehouse=wh.id_book_warehouse  " +
                        " group by wh.id_book, oh.id_book_warehouse " +
                        " ) as ppb , books as b " +
                        " where ppb.id_book = b.id_book " +
                        " group by ppb.id_book " +
                        ") as ppb , book_author as ab, authors as a " +
                        "where ppb.id_book=ab.id_book ANd ab.id_author= a.id_author " +
                        "group by a.id_author" );


        List<Object[]> tmp=query.getResultList();
        List<ProfitPerAuthor> result = new ArrayList<ProfitPerAuthor>();
        for(Object[] tmpp : tmp){
            result.add(new ProfitPerAuthor(tmpp[0].toString(),tmpp[1].toString(),((BigDecimal)tmpp[2]).floatValue()));
        }

        return result;
    }
}
