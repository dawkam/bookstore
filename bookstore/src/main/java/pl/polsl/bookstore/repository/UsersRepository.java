package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersRepository {
    @PersistenceContext
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
    public Users registerUser(Users user){

        this.entityManager.persist(user);
        return user;
    }

    @Transactional
    public Users updateUser(Users user, String password, String name, String surname, String nation, String city, String street, String email){
        Query query = (Query) entityManager.createQuery("UPDATE Users u SET password = :password, first_name = :name, surname = :surname, nation = :nation, city = :city, street = :street, email = :email" +
                " WHERE id_user = :id");
        int updateQuery = query
                            .setParameter("password", password)
                            .setParameter("name", name)
                            .setParameter("surname", surname)
                            .setParameter("nation", nation)
                            .setParameter("city", city)
                            .setParameter("street", street)
                            .setParameter("email", email)
                            .setParameter("id", user.getIdUser())
                .executeUpdate();
        return user;
    }

    @Transactional
    public Users findById(long id){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("SELECT u FROM Users u WHERE u.idUser = :id")
                .setParameter("id", id);

        return (Users) theQuery.getSingleResult();
    }

}
