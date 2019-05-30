package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="warehouse")
public class Warehouse {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id_book_warehouse")
  private long idBookWarehouse;

  @ManyToOne
  @JoinColumn(name="id_book" , referencedColumnName = "id_book")
  Books booksW;

  @ManyToOne
  @JoinColumn(name="id_format" , referencedColumnName = "id_format")
  BookFormat bookFormatW;

  @Column(name="price")
  private double price;

  @Column(name="discount")
  private double discount;

  @Column(name="quantity")
  private long quantity;

  @Column(name="purchase_price")
  private double purchasePrice;

  @OneToMany(mappedBy="usersOr",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<OrderHistory> orderHistory;

  @OneToMany(mappedBy="usersSh",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<ShoppingCart> shoppingCart;

  public long getIdBookWarehouse() {
    return idBookWarehouse;
  }

  public void setIdBookWarehouse(long idBookWarehouse) {
    this.idBookWarehouse = idBookWarehouse;
  }

  public Books getBooksW() {
    return booksW;
  }

  public void setBooksW(Books booksW) {
    this.booksW = booksW;
  }

  public BookFormat getBookFormatW() {
    return bookFormatW;
  }

  public void setBookFormatW(BookFormat bookFormatW) {
    this.bookFormatW = bookFormatW;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public double getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(double purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public Set<OrderHistory> getOrderHistory() {
    return orderHistory;
  }

  public void setOrderHistory(Set<OrderHistory> orderHistory) {
    this.orderHistory = orderHistory;
  }

  public Set<ShoppingCart> getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  public double calculatePrice(long quantity)
  {
    double thequantity=(double)quantity;
    double total=(price - ( price*discount/100))*thequantity;
    return total;
  }
}
