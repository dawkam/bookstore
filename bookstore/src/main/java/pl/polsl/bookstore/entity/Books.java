package pl.polsl.bookstore.entity;


import javax.persistence.*;
import java.util.List;
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

  @Column(name="image")
  private String image;

  @OneToMany(mappedBy="booksB",cascade = CascadeType.ALL, fetch = FetchType.EAGER)       //przy mapowaniach ostatnia litera nazwy jest to pierwsza litera (lub litery) klasy z ktora sie laczy(zabezpiecza w momencie,
  private Set<BookAuthor> bookAuthor;                                                    // gdy z jednej tablicy jest wiele mapowan)

  @OneToMany(mappedBy="booksO",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Opinions> opinions;

  @OneToMany(mappedBy="booksW",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Warehouse> warehouse;

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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Set<BookAuthor> getBookAuthor() {
    return bookAuthor;
  }

  public void setBookAuthor(Set<BookAuthor> bookAuthor) {
    this.bookAuthor = bookAuthor;
  }

  public Set<Opinions> getOpinions() {
    return opinions;
  }

  public void setOpinions(Set<Opinions> opinions) {
    this.opinions = opinions;
  }

  public List<Warehouse> getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(List<Warehouse> warehouse) {
    this.warehouse = warehouse;
  }

  public String getFullName(){
    final String[] fullName = new String[1];
    fullName[0]="";
    this.getBookAuthor().forEach((BookAuthor author) -> { fullName[0] +=
      author.getAuthorsB().getFirstName() + " " + author.getAuthorsB().getSurname() + " ";
    });
    return fullName[0];
  }
}
