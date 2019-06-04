package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Authors;
import pl.polsl.bookstore.entity.Warehouse;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WarehouseRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public WarehouseRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Warehouse> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Warehouse> theQuery =
                currentSession.createQuery("from Warehouse", Warehouse.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Warehouse> warehouse = theQuery.getResultList();

        // return the results
        return warehouse;
    }

    @Transactional
    public Warehouse findWarehouse(Warehouse warehouse){
        try{
            Query<Warehouse> query = (Query<Warehouse>) entityManager.createQuery("SELECT w FROM Warehouse w WHERE w.bookW = :book AND w.bookFormatW = :foramt")
                    .setParameter("book", warehouse.getBooksW())
                    .setParameter("foramt", warehouse.getBookFormatW());
            return query.getSingleResult();
        }
        catch (Exception e){
            return warehouse;
        }
    }

    @Transactional
    public void addWarehouse(Warehouse warehouse)
    {
        this.entityManager.persist(warehouse);
    }
}
