package pl.polsl.bookstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.Books;
import pl.polsl.bookstore.repository.BooksRepository;


@RestController
@RequestMapping("/api")
public class BooksRestController {

    private BooksRepository booksRepository;

    @Autowired
    public BooksRestController(BooksRepository theBooksRepository ){    booksRepository =  theBooksRepository;  }
}
