package pl.polsl.bookstore.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.bookstore.entity.Books;
import pl.polsl.bookstore.entity.Opinions;
import pl.polsl.bookstore.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OpinionsRepository {
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public OpinionsRepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    public List<Opinions> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Opinions> theQuery =
                currentSession.createQuery("from Opinions", Opinions.class);      //from odnosi sie do klasy nie do tabeli

        // execute query and get result list
        List<Opinions> opinions = theQuery.getResultList();

        // return the results
        return opinions;
    }

    @Transactional
    public void addOpinion(Opinions opinion) {entityManager.persist(opinion);}

    @Transactional
    public void updateOpinion(Opinions opinion){
        Query query = (Query) entityManager.createQuery("UPDATE Opinions o SET o.opinion = :opinion" +
                " WHERE o.usersO.idUser = :id AND o.booksO.idBook = :bookId")
                .setParameter("opinion", opinion.getOpinion())
                .setParameter("id",opinion.getUsersO().getIdUser())
                .setParameter("bookId", opinion.getBooksO().getIdBook());
        int updateQuery = query.executeUpdate();
    }

    @Transactional
    public void updateReported(Opinions opinions){
        Query query = (Query) entityManager.createQuery("UPDATE Opinions o SET o.reported = :reported WHERE o.usersO.idUser = :id AND o.booksO.idBook = :bookId")
                .setParameter("reported", opinions.getReported()+1)
                .setParameter("id", opinions.getUsersO().getIdUser())
                .setParameter("bookId", opinions.getBooksO().getIdBook());
        int updateQuery = query.executeUpdate();
    }

    @Transactional
    public Opinions findOpinionByIds(long userId, long bookId){
        Query query = (Query) entityManager.createQuery("SELECT o FROM Opinions o WHERE o.booksO.idBook = :bookId AND o.usersO.idUser = :userId")
                .setParameter("bookId", bookId)
                .setParameter("userId", userId);
        return (Opinions) query.getSingleResult();

    }

    @Transactional
    public List<Opinions> findReported(){
        Query<Opinions> theQuery = (Query<Opinions>) entityManager.createQuery("SELECT o FROM Opinions o WHERE o.reported > 0");
        List<Opinions> opinions = theQuery.getResultList();
        return opinions;
    }

    @Transactional
    public void deleteUsersOpinions(Users user){
        Query query = (Query) entityManager.createQuery("DELETE FROM Opinions WHERE usersO.idUser = :id")
                .setParameter("id",user.getIdUser());
        int deleteQuery = query
                .executeUpdate();
    }

    @Transactional
    public void deleteOpinion(Opinions opinion){
        Query query = (Query) entityManager.createQuery("DELETE FROM Opinions WHERE booksO.idBook = :bookId AND usersO.idUser = :id")
                .setParameter("id",opinion.getUsersO().getIdUser())
                .setParameter("bookId",opinion.getBooksO().getIdBook());
        int deleteQuery = query
                .executeUpdate();
    }


}
