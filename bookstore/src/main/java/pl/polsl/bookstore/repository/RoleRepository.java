package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Role;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public RoleRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Role> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Role> theQuery =
                currentSession.createQuery("from Role", Role.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Role> Role = theQuery.getResultList();

        // return the results
        return Role;
    }

    @Transactional
    public Role findRole(String role)
    {
        Query<Role> query = (Query<Role>) entityManager.createQuery("From Role Where role=:role" );
        Role result = query
                .setParameter("role", role)
               .getSingleResult();
        return result;

    }

}