package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.BookFormat;
import pl.polsl.bookstore.repository.BookFormatRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookFormatRestController {

    private BookFormatRepository bookFormatsRepository;

    @Autowired
    public BookFormatRestController(BookFormatRepository theBookFormatRepository ){    bookFormatsRepository =  theBookFormatRepository;  }


    // expose "/bookFormats" and return list of bookFormats
    @GetMapping("/bookFormats")
    public List<BookFormat> findAll(){return bookFormatsRepository.findAll();}


}
