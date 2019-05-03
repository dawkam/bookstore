package pl.polsl.bookstore.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="opinions")
public class Opinions implements Serializable {


  @Id
  @ManyToOne
  @JoinColumn(name="books", nullable=false)
  Books booksO;

  @Id
  @ManyToOne
  @JoinColumn(name="users", nullable=false)
  Users usersO;

  @Column(name="opinion")
  private String opinion;

    public Books getBooksO() {
        return booksO;
    }

    public void setBooksO(Books booksO) {
        this.booksO = booksO;
    }

    public Users getUsersO() {
        return usersO;
    }

    public void setUsersO(Users usersO) {
        this.usersO = usersO;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
