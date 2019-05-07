package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UsersRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public UsersRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Users> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Users> theQuery =
                currentSession.createQuery("from Users", Users.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Users> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Transactional
    public Users registerUser(){
        Users user= new Users();

        return user;
    }
}
