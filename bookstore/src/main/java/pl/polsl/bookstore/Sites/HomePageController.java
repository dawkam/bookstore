package pl.polsl.bookstore.Sites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.entity.BookAuthor;
import pl.polsl.bookstore.repository.BooksRepository;


@Controller
public class HomePageController {

    private BooksRepository bookRepo;

    @Autowired
    public HomePageController(BooksRepository theBookRepo){
        bookRepo = theBookRepo;
    }

    @GetMapping("/home")
    public String getGreeting(@RequestParam(name ="bookName", required = false, defaultValue = "") String bookName, Model model) {
        model.addAttribute("bookList", bookRepo.booksSearch(bookName));
        return "home";
    }

    @PostMapping("/home")
    public String postGreeting() {

        return "home";
    }

    @GetMapping("/login")
    public String getLogin() {

        return "login";
    }

    @PostMapping("/login")
    public String postLogin() {

        return "login";
    }


}
