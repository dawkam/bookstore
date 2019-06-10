package pl.polsl.bookstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="book_author")
public class BookAuthor implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name="id_author", referencedColumnName = "id_author")
  Authors authorsB;

  @Id
  @ManyToOne
  @JoinColumn(name="id_book" , referencedColumnName = "id_book")
  Books booksB;

  public Authors getAuthorsB() {
    return authorsB;
  }

  public void setAuthorsB(Authors authorsB) {
    this.authorsB = authorsB;
  }

  public Books getBooksB() {
    return booksB;
  }

  public void setBooksB(Books booksA) {
    this.booksB = booksA;
  }

  public BookAuthor(Authors authorsB, Books booksB) {
    this.authorsB = authorsB;
    this.booksB = booksB;
  }

  public BookAuthor() {
  }
}
