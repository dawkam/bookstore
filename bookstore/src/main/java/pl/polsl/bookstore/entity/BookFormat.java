package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="book_format")
public class BookFormat {


  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id_format")
  private long idFormat;

  @Column(name="book_format")
  private String bookFormat;

  @OneToMany(mappedBy="bookFormatW",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
  private Set<Warehouse> warehouse;

  public long getIdFormat() {
    return idFormat;
  }

  public void setIdFormat(long idFormat) {
    this.idFormat = idFormat;
  }


  public String getBookFormat() {
    return bookFormat;
  }

  public void setBookFormat(String bookFormat) {
    this.bookFormat = bookFormat;
  }

}


