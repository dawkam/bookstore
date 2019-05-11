package pl.polsl.bookstore.Sites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.entity.BookAuthor;
import pl.polsl.bookstore.entity.Users;
import pl.polsl.bookstore.repository.BooksRepository;
import pl.polsl.bookstore.repository.UsersRepository;

import javax.validation.constraints.Null;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class HomePageController {

    private BooksRepository bookRepo;
    private UsersRepository usersRepo;
    private Users currentUser;

    @Autowired
    public HomePageController(BooksRepository theBookRepo, UsersRepository theUsersRepo){
        bookRepo = theBookRepo;
        usersRepo= theUsersRepo;
    }

    @GetMapping("/home")
    public String getGreeting(@RequestParam(name ="bookName", required = false, defaultValue = "") String bookName, Model model) {
        model.addAttribute("bookList", bookRepo.booksSearch(bookName));
        model.addAttribute("user", currentUser);
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

    @GetMapping("/register")
    public String getRegister()
    {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String login, String password, String passwordConfirm, String name, String surname, String nation, String city, String street, String email)
    {
        //walidacja loginu
        for (Users user:usersRepo.findAll()){
            if(login.equals(user.getLogin()))
            {

                return "register";
            }
        }
        //walidacja hasla
        if(password.equals(passwordConfirm)) {
            //walidacja emaila
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            if(m.matches())
            {
                try {
                    currentUser = usersRepo.registerUser(login,password,name,surname,nation,city,street,email);
                    return "home";

                }
                catch(Exception e)
                {
                    return "register";
                }
            }
            else
            {

                return "register";
            }
        }
        else
        {

            return "register";
        }
    }
}
