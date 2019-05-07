package pl.polsl.bookstore.Sites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.HibernateSearchService;
import pl.polsl.bookstore.repository.BooksRepository;

@Controller
public class HomePageController {

    private BooksRepository bookRepo;
    private HibernateSearchService searchService;

    @Autowired
    public HomePageController(BooksRepository theBookRepo, HibernateSearchService searchService){
        bookRepo = theBookRepo;
        this.searchService = searchService;
    }

    @GetMapping("/")
    public String getGreeting(@RequestParam(name ="bookName", required = false, defaultValue = "") String bookName, Model model) {
        model.addAttribute("bookList", bookRepo.booksSearch(bookName));
        return "home";
    }

    @PostMapping("/")
    public String postGreeting() {

        return "home";
    }

    @RequestMapping("/profile")
    public String goToProfile(){
        return "profile";
    }


//    @GetMapping(value="/searchFor")
//    public String getSearchForBooks(@ModelAttribute("book") Books book, Model model){
//
//        return "home";
//    }
//
//    @PostMapping(value="/searchFor")
//    public String postSearchForBooks(@ModelAttribute("book") Books book, Model model){
//
//        return "home";
//    }


}
