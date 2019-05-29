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

    @PostMapping("/logout")
    public String postLogout() {
        currentUser=null;
        return "redirect:home";
    }

    @GetMapping("/login")
    public String getLogin() {
        if(currentUser != null)
            return "redirect:home";
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String login, String password) {
        for (Users user:usersRepo.findAll()){
            if(login.equals(user.getLogin()))
            {
                if(password.equals(user.getPassword()))
                {
                    currentUser = user;
                    return "redirect:home";
                }
                else
                {
                    //Trzeba dodac pop-up
                    return "login";
                }
            }
        }
        //Trzeba dodac pop-up

        return "login";
    }

    @GetMapping("/register")
    public String getRegister()
    {
        if (currentUser != null)
            return "redirect:home";
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String login, String password, String passwordConfirm, String name, String surname, String nation, String city, String street, String email)
    {
        //walidacja loginu
        for (Users user:usersRepo.findAll()){
            if(login.equals(user.getLogin()))
            {
                //Trzeba dodac pop-up
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
                    return "redirect:home";

                }
                catch(Exception e)
                {
                    //Trzeba dodac pop-up
                    return "register";
                }
            }
            else
            {
                //Trzeba dodac pop-up
                return "register";
            }
        }
        else
        {
            //Trzeba dodac pop-up
            return "register";
        }
    }

    @GetMapping("/profile")
    public String getProfile(Model model)
    {
        if (currentUser == null)
            return "redirect:home";
        model.addAttribute("user", currentUser);
        return "profile";
    }

    @PostMapping("/profile")
    public String postProfile(@RequestParam (required = false)String password, String passwordConfirm, String name, String surname, String nation, String city, String street, String email) {
        //walidacja hasla
        if (password.equals(passwordConfirm) || (passwordConfirm == "" && password.equals(currentUser.getPassword()))) {
            //walidacja emaila
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            if (m.matches()) {
                usersRepo.updateUser(currentUser, password, name, surname, nation, city, street, email);
                currentUser.setEmail(email);
                currentUser.setStreet(street);
                currentUser.setCity(city);
                currentUser.setNation(nation);
                currentUser.setSurname(surname);
                currentUser.setFirstName(name);
                currentUser.setPassword(password);
                return "redirect:home";
            }
        }
        return "redirect:profile";
    }

    @GetMapping("/shoppingCart")
    public String getShoppingCart()
    {

        return "shoppingCart";
    }

    @PostMapping("/shoppingcart")
    public String postShoppingCart(@RequestParam int quantity)
    {
        return "shoppingCart";
    }

}
