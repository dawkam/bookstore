package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name="id_book_warehouse" , referencedColumnName = "id_book_warehouse")
  Warehouse warehouseSh;

  @Id
  @ManyToOne
  @JoinColumn(name="id_user" , referencedColumnName = "id_user")
  Users usersSh;

  @Column(name="quantity")
  private long quantity;

  public Warehouse getWarehouseSh() {
    return warehouseSh;
  }

  public void setWarehouseSh(Warehouse warehouseSh) {
    this.warehouseSh = warehouseSh;
  }

  public Users getUsersSh() {
    return usersSh;
  }

  public void setUsersSh(Users usersSh) {
    this.usersSh = usersSh;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}
