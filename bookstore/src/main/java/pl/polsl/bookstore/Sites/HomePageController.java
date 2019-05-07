package pl.polsl.bookstore.Sites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.repository.BooksRepository;

@Controller
public class HomePageController {

    private BooksRepository bookRepo;

    @Autowired
    public HomePageController(BooksRepository theBookRepo){
        bookRepo = theBookRepo;
    }

    @GetMapping("/")
    public String getGreeting(Model model) {
        model.addAttribute("bookList", bookRepo.findAll());
        return "home";
    }

    @PostMapping("/")
    public String postGreeting(@RequestParam String bookName) {

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
