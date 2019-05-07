package pl.polsl.bookstore.Sites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.repository.BookAuthorRepository;


@Controller
public class HomePageController {

    private BookAuthorRepository bookAuthorRepo;

    @Autowired
    public HomePageController(BookAuthorRepository theBookAuthorRepo){
        bookAuthorRepo = theBookAuthorRepo;
    }

    @GetMapping("/home")
    public String getGreeting(@RequestParam(name ="bookName", required = false, defaultValue = "") String bookName, Model model) {
        model.addAttribute("bookAuthorList", bookAuthorRepo.bookTitleSearch(bookName));
        return "home";
    }

    @PostMapping("/home")
    public String postGreeting() {

        return "home";
    }

    @RequestMapping("/profile")
    public String goToProfile(){
        return "profile";
    }

}
