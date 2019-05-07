package pl.polsl.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="order_history")
public class OrderHistory implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name="id_book_warehouse" , referencedColumnName = "id_book_warehouse")
  Warehouse warehouseOr;

  @Id
  @ManyToOne
  @JoinColumn(name="id_user" , referencedColumnName = "id_user")
  Users usersOr;

  @Column(name="date")
  @JsonFormat(pattern="yyyy-MM-dd")
  private java.sql.Date date;

  @Column(name="quantity")
  private long quantity;

  @Column(name="purchase_price")
  private long purchasePrice;


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

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public long getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(long purchasePrice) {
    this.purchasePrice = purchasePrice;
  }
}
