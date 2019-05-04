package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.BookAuthor;
import pl.polsl.bookstore.repository.BookAuthorRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookAuthorRestController {

    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    public BookAuthorRestController(BookAuthorRepository theBookAuthorRepository ){    bookAuthorRepository =  theBookAuthorRepository;  }


    // expose "/bookAuthor" and return list of bookAuthor
    @GetMapping("/bookAuthor")
    public List<BookAuthor> findAll(){return bookAuthorRepository.findAll();}


}
