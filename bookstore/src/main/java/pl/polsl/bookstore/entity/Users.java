package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class Users {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id_user")
  private long idUser;

  @Column(name="first_name")
  private String firstName;

  @Column(name="surname")
  private String surname;

  @Column(name="nation")
  private String nation;

  @Column(name="city")
  private String city;

  @Column(name="street")
  private String street;

  @Column(name="login")
  private String login;

  @Column(name="password")
  private String password;

  @Column(name="email")
  private String email;

  @Column(name="access_to_comments")
  private long accessToComments;

  @OneToMany(mappedBy="usersOr",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<OrderHistory> orderHistory;

  @OneToMany(mappedBy="usersO",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Opinions> Opinions;

  @OneToMany(mappedBy="usersSh",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<ShoppingCart> shoppingCart;

  public long getIdUser() {
    return idUser;
  }

  public void setIdUser(long idUser) {
    this.idUser = idUser;
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


  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getAccessToComments() {
    return accessToComments;
  }

  public void setAccessToComments(long accessToComments) {
    this.accessToComments = accessToComments;
  }


}
