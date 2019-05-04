package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.Books;
import pl.polsl.bookstore.repository.BooksRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksRestController {

    private BooksRepository booksRepository;

    @Autowired
    public BooksRestController(BooksRepository theBooksRepository ){    booksRepository =  theBooksRepository;  }


    // expose "/books" and return list of books
    @GetMapping("/books")
    public List<Books> findAll(){return booksRepository.findAll();}


}
