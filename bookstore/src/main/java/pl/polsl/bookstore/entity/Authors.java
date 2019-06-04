package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="authors")
public class Authors {


  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id_author")
  private long idAuthor;

  @Column(name="first_name")
  private String firstName;

  @Column(name="surname")
  private String surname;

 @OneToMany(mappedBy="authorsB",cascade = CascadeType.ALL, fetch = FetchType.LAZY )  //mappedby nazwa obiektu w klasie ktora ma ManyToOne
  private Set<BookAuthor> bookAuthor;


  public long getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(long idAuthor) {
    this.idAuthor = idAuthor;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void addBookAuthor(BookAuthor bookAuthor){
      this.bookAuthor.add(bookAuthor);
  }

  public Authors(String firstName, String surname){
      this.firstName=firstName;
      this.surname= surname;
      this.bookAuthor =null;
  }

    public Authors() {}
}
