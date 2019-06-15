package pl.polsl.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name="order_history")
public class OrderHistory implements Serializable {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id_order_history")
  private long idOrderHistory;

  @ManyToOne
  @JoinColumn(name="id_book_warehouse" , referencedColumnName = "id_book_warehouse")
  Warehouse warehouseOr;


  @ManyToOne
  @JoinColumn(name="id_user" , referencedColumnName = "id_user")
  Users usersOr;

  @Column(name="date")
  @JsonFormat(pattern="yyyy-MM-dd")
  private java.sql.Date date;

  @Column(name="quantity")
  private long quantity;

  @Column(name="purchase_price")
  private double purchasePrice;

  public OrderHistory(Warehouse warehouseOr, Users usersOr, Date date, long quantity, double purchasePrice) {
    this.warehouseOr = warehouseOr;
    this.usersOr = usersOr;
    this.date = date;
    this.quantity = quantity;
    this.purchasePrice = purchasePrice;
  }

  public OrderHistory(){

  }

  public long getIdOrderHistory() {
    return idOrderHistory;
  }

  public void setIdOrderHistory(long idOrderHistory) {
    this.idOrderHistory = idOrderHistory;
  }

  public Warehouse getWarehouseOr() {
    return warehouseOr;
  }

  public void setWarehouseOr(Warehouse warehouseOr) {
    this.warehouseOr = warehouseOr;
  }

  public Users getUsersOr() {
    return usersOr;
  }

  public void setUsersOr(Users usersOr) {
    this.usersOr = usersOr;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getYear()
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.YEAR);

  }

  public int getMonth()
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.MONTH);

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

  public void setPurchasePrice(long purchasePrice) {
    this.purchasePrice = purchasePrice;
  }
}
