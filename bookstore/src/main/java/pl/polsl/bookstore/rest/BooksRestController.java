package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.HibernateSearchService;
import pl.polsl.bookstore.entity.Books;
import pl.polsl.bookstore.repository.BooksRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksRestController {

    private BooksRepository booksRepository;

    @Autowired
    private HibernateSearchService searchservice;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<Books> searchResults = null;
        try {
            searchResults = searchservice.booksSearch(q);

        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
        }
        model.addAttribute("search", searchResults);
        return "index";

    }


    @Autowired
    public BooksRestController(BooksRepository theBooksRepository ){    booksRepository =  theBooksRepository;  }


    // expose "/books" and return list of books
    @GetMapping("/books")
    public List<Books> findAll(){return booksRepository.findAll();}


}
