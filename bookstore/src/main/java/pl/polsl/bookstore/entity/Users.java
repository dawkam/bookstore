package pl.polsl.bookstore.entity;

import pl.polsl.bookstore.repository.RoleRepository;
import pl.polsl.bookstore.repository.UsersRepository;

import javax.persistence.*;
import java.util.List;

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
  private boolean accessToComments;

  @ManyToOne
  @JoinColumn(name="id_role" , referencedColumnName = "id_role")
  Role roleU;

  @OneToMany(mappedBy="usersOr",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OrderHistory> orderHistory;

  @OneToMany(mappedBy="usersO",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Opinions> opinions;

  @OneToMany(mappedBy="usersSh",cascade = CascadeType.ALL, fetch = FetchType.EAGER )
  private List<ShoppingCart> shoppingCart;



  public boolean isAccessToComments() {
    return accessToComments;
  }

  public List<OrderHistory> getOrderHistory() {
    return orderHistory;
  }

  public void setOrderHistory(List<OrderHistory> orderHistory) {
    this.orderHistory = orderHistory;
  }

  public List<Opinions> getOpinions() {
    return opinions;
  }

  public void setOpinions(List<Opinions> opinions) {
    this.opinions = opinions;
  }

  public List<ShoppingCart> getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(List<ShoppingCart> shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  public void deleteBookFromShoppingCart(ShoppingCart theShoppingCart)
  {
    shoppingCart.remove(theShoppingCart);

  }

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


  public boolean getAccessToComments() {
    return accessToComments;
  }

  public void setAccessToComments(boolean accessToComments) {
    this.accessToComments = accessToComments;
  }

  public Users(String login, String password, String firstName, String surname, String nation, String city, String street, String email, Role role) {
    this.firstName = firstName;
    this.surname = surname;
    this.nation = nation;
    this.city = city;
    this.street = street;
    this.login = login;
    this.password = password;
    this.email = email;
    this.accessToComments = true;
    this.orderHistory = null;
    this.shoppingCart = null;
    this.opinions = null;
    this.roleU=role;
  }

  public Users() {}
}
