package pl.polsl.bookstore.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="books")
public class Books {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id_book")
  private long idBook;

  @Column(name="title")
  private String title;

  @Column(name="genre")
  private String genre;

  @Column(name="number_of_pages")
  private long numberOfPages;

  @OneToMany(mappedBy="booksB",cascade = CascadeType.ALL, fetch = FetchType.LAZY)       //przy mapowaniach ostatnia litera nazwy jest to pierwsza litera (lub litery) klasy z ktora sie laczy(zabezpiecza w momencie,
  private Set<BookAuthor> bookAuthor;                                                    // gdy z jednej tablicy jest wiele mapowan)

  @OneToMany(mappedBy="booksO",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Opinions> opinions;

  @OneToMany(mappedBy="booksW",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Warehouse> warehouse;

  public long getIdBook() {
    return idBook;
  }

  public void setIdBook(long idBook) {
    this.idBook = idBook;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }


  public long getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(long numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

}
