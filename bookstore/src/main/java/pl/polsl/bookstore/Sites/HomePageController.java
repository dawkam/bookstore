package pl.polsl.bookstore.Sites;


//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.bookstore.entity.*;
import pl.polsl.bookstore.repository.*;

import javax.validation.constraints.Null;
import java.awt.print.Book;
import java.util.Iterator;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class HomePageController {

    private BooksRepository bookRepo;
    private BookFormatRepository bookFormatRepo;
    private BookAuthorRepository bookAuthorRepo;
    private AuthorsRepository authorsRepo;
    private UsersRepository usersRepo;
    private ShoppingCartRepository shoppingCartRepo;
    private OrderHistoryRepository orderHistoryRepo;
    private OpinionsRepository opinionsRepo;
    private RoleRepository roleRepo;
    private WarehouseRepository warehouseRepo;
    private Users currentUser;
    private ShoppingCart cart;

    @Autowired
    public HomePageController(BookAuthorRepository theBookAuthorRepo, BooksRepository theBookRepo,BookFormatRepository theBookFormatRepo, AuthorsRepository theAuthorsRepo, UsersRepository theUsersRepo,ShoppingCartRepository  theShoppingCartRepo,OrderHistoryRepository theOrderHistoryRepo,OpinionsRepository theOpinionsRepo, RoleRepository theRoleRepo, WarehouseRepository theWarehouseRepo){
        bookRepo = theBookRepo;
        bookFormatRepo= theBookFormatRepo;
        bookAuthorRepo = theBookAuthorRepo;
        authorsRepo= theAuthorsRepo;
        usersRepo= theUsersRepo;
        shoppingCartRepo=theShoppingCartRepo;
        orderHistoryRepo = theOrderHistoryRepo;
        opinionsRepo = theOpinionsRepo;
        roleRepo= theRoleRepo;
        warehouseRepo = theWarehouseRepo;
    }

    @GetMapping("/home")
    public String getGreeting(@RequestParam Map<String, String> requestParams, Model model) {

        String bookName = (requestParams.get("bookName") != null) ? requestParams.get("bookName") : "";
        model.addAttribute("bookList", bookRepo.booksSearch(bookName));
        String authorNameAZ = (requestParams.get("authorName(a-z)") != null) ? requestParams.get("authorName(a-z)") : "";
        if (authorNameAZ.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByAuthorName(true));
        }
        String authorNameZA = (requestParams.get("authorName(z-a)") != null) ? requestParams.get("authorName(z-a)") : "";
        if (authorNameZA.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByAuthorName(false));
        }
        String authorAZ = (requestParams.get("author(a-z)") != null) ? requestParams.get("author(a-z)") : "";
        if (authorAZ.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByAuthor(true));
        }
        String authorZA = (requestParams.get("author(z-a)") != null) ? requestParams.get("author(z-a)") : "";
        if (authorZA.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByAuthor(false));
        }
        String titleAZ = (requestParams.get("title(a-z)") != null) ? requestParams.get("title(a-z)") : "";
        if (titleAZ.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByTitle(true));
        }
        String titleZA = (requestParams.get("title(z-a)") != null) ? requestParams.get("title(z-a)") : "";
        if (titleZA.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByTitle(false));
        }
        String priceLowest = (requestParams.get("price_lowest") != null) ? requestParams.get("price_lowest") : "";
        if (priceLowest.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByPrice(true));
        }
        String priceHighest = (requestParams.get("price_highest") != null) ? requestParams.get("price_highest") : "";
        if (priceHighest.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByPrice(false));
        }
        String priceHighestEbook = (requestParams.get("price_highest_e_book") != null) ? requestParams.get("price_highest_e_book") : "";
        if (priceHighestEbook.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByPriceEbook(false));
        }
        String priceLowestEbook = (requestParams.get("price_lowest_e_book") != null) ? requestParams.get("price_lowest_e_book") : "";
        if (priceLowestEbook.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByPriceEbook(true));
        }
        String priceHighestAudiobook = (requestParams.get("price_highest_audiobook") != null) ? requestParams.get("price_highest_audiobook") : "";
        if (priceHighestAudiobook.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByPriceAudiobook(false));
        }
        String priceLowestAudiobook = (requestParams.get("price_lowest_audiobook") != null) ? requestParams.get("price_lowest_audiobook") : "";
        if (priceLowestAudiobook.equals("True")) {
            model.addAttribute("bookList", bookRepo.searchByPriceAudiobook(true));
        }
        model.addAttribute("user", currentUser);
        return "home";
    }

    @PostMapping("/home")
    public String postGreeting() {
        return "home";
    }

    @PostMapping("/logout")
    public String postLogout() {
        currentUser = null;
        return "redirect:home";
    }

    @GetMapping("/login")
    public String getLogin() {
        if (currentUser != null)
            return "redirect:home";
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String login, String password) {
        for (Users user : usersRepo.findAll()) {
            if (login.equals(user.getLogin())) {
                if (password.equals(user.getPassword())) {
                    currentUser = user;
                    return "redirect:home";
                } else {
                    //Trzeba dodac pop-up
                    return "login";
                }
            }
        }
        //Trzeba dodac pop-up

        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        if (currentUser != null)
            return "redirect:home";
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String login, String password, String passwordConfirm, String name, String surname, String nation, String city, String street, String email) {
        //walidacja loginu
        for (Users user : usersRepo.findAll()) {
            if (login.equals(user.getLogin())) {
                //Trzeba dodac pop-up
                return "register";
            }
        }
        //walidacja hasla
        if (password.equals(passwordConfirm)) {
            //walidacja emaila
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            if (m.matches()) {

                try {
                    Users user= new Users(login,password,name,surname,nation,city,street,email, roleRepo.findRole("user"));
                    currentUser = usersRepo.registerUser(user);
                    return "redirect:home";

                } catch (Exception e) {
                    //Trzeba dodac pop-up
                    return "register";
                }
            } else {
                //Trzeba dodac pop-up
                return "register";
            }
        } else {
            //Trzeba dodac pop-up
            return "register";
        }
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        if (currentUser == null)
            return "redirect:home";
        model.addAttribute("user", currentUser);
        return "profile";
    }

    @PostMapping("/profile")
    public String postProfile(@RequestParam(required = false) String password, String passwordConfirm, String name, String surname, String nation, String city, String street, String email) {
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
    public String getShoppingCart(@RequestParam(defaultValue = "") String formatKsiazki, @RequestParam(required = false)Warehouse warehouse, Model model)
    {
        if (currentUser == null)
            return "redirect:login";
        cart = new ShoppingCart();
        cart.setQuantity(1);
        cart.setUsersSh(currentUser);
        cart.setWarehouseSh(warehouse);
        shoppingCartRepo.updateShoppingCart(cart);

        model.addAttribute("user", currentUser);

        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/changeQuantity")
    public String postShoppingCartChangeQuantity(@RequestParam(required = false)long idWarehouse, int quantity, Model model)
    {

            shoppingCartRepo.updateShoppingCartQuantity(idWarehouse, currentUser.getIdUser(), quantity);
            ShoppingCart tmp;
            for (ShoppingCart shoppingcart : currentUser.getShoppingCart()) {
                if (shoppingcart.getWarehouseSh().getIdBookWarehouse() == idWarehouse) {
                    tmp = shoppingcart;
                    tmp.setQuantity(quantity);
                }
            }
        model.addAttribute("user", currentUser);
        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/deleteBook")
    public String postShoppingCartDeleteBook(@RequestParam(required = false)long idWarehouse, Model model)
    {
        shoppingCartRepo.deleteBookFromShoppingCart(idWarehouse, currentUser.getIdUser());
        ShoppingCart tmp= new ShoppingCart();
        for (ShoppingCart shoppingcart : currentUser.getShoppingCart()) {

            if (shoppingcart.getWarehouseSh().getIdBookWarehouse() == idWarehouse) {
                tmp = shoppingcart;
            }
        }
        currentUser.deleteBookFromShoppingCart(tmp);
        model.addAttribute("user", currentUser);
        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/pay")
    public String postShoppingCartPay(Model model)
    {
        Iterator iterator= currentUser.getShoppingCart().iterator();
        ShoppingCart shoppingcart= new ShoppingCart();

        while(iterator.hasNext()){
            shoppingcart=(ShoppingCart)iterator.next();
            orderHistoryRepo.addOrderHistory(shoppingcart.getWarehouseSh(),currentUser,shoppingcart.getQuantity(),shoppingcart.getWarehouseSh().calculatePrice(shoppingcart.getQuantity()));
            iterator.remove();
        }
        shoppingCartRepo.deleteBooksFromShoppingCart(currentUser.getIdUser());
        model.addAttribute("user", currentUser);
        return "shoppingCart";
    }


    @PostMapping("/book")
    public String postBook() {
        return "book";
    }

    @GetMapping("/book")
    public String getBook(@RequestParam String bookId, Model model) {
        model.addAttribute("user", currentUser);
        Books book = bookRepo.findBookById(bookId);
        model.addAttribute("bookSelected", book);
        model.addAttribute("paperFormat", null);
        model.addAttribute("eBookFormat", null);
        model.addAttribute("audiobookFormat", null);
        for (Books tmpBook : bookRepo.findAll()) {
            List<Books> tmp0 = bookRepo.findAll();
            String tmp1= Long.toString(tmpBook.getIdBook());
            String tmp2 = tmpBook.getWarehouse().get(0).getBookFormatW().getBookFormat();
            if (Long.toString(tmpBook.getIdBook()).equals(bookId))
                for(Warehouse wh:tmpBook.getWarehouse()){
                    if(wh.getBookFormatW().getBookFormat().equals("książka")){
                        model.addAttribute("paperFormat", "True");
                        model.addAttribute("bookPricePaper", wh.getPrice());
                        model.addAttribute("warehouse", wh);
                    }
                    if(wh.getBookFormatW().getBookFormat().equals("e-book")){
                        model.addAttribute("eBookFormat", "True");
                        model.addAttribute("bookPriceEbook", wh.getPrice());
                        model.addAttribute("warehouse", wh);
                    }
                    if(wh.getBookFormatW().getBookFormat().equals("audiobook")){
                        model.addAttribute("audiobookFormat", "True");
                        model.addAttribute("bookPriceAudiobook", wh.getPrice());
                        model.addAttribute("warehouse", wh);
                    }
                }
        }
        return "book";
    }

    @GetMapping("/newBook")
    public String getNewBook(){
        if(currentUser ==null)
            return "redirect:home";
        if(currentUser.getRoleU().getRole().equals("worker"))
            return "newBook";
        else{
            return "redirect:home";
        }
    }

    @PostMapping("/newBook")
    public String postNewBook(@RequestParam String title, String name, String surname, String cover, String type,double purchasePrize, double prize,double discount, long quantity, String description, String genre ,long pages){
        try{

            Books book = new Books(title,genre,pages,cover,description);
            book = bookRepo.findBook(book);
            bookRepo.addBook(book);

            Authors author= authorsRepo.findAuthor(name,surname);
            authorsRepo.addAuthor(author);

            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setBooksB(book);
            bookAuthor.setAuthorsB(author);
            bookAuthorRepo.addBookAuthor(bookAuthor);

            Warehouse warehouse = new Warehouse(book,bookFormatRepo.findByName(type),prize,discount,quantity,purchasePrize);
            //warehouse = warehouseRepo.findWarehouse(warehouse);
            warehouseRepo.addWarehouse(warehouse);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:newBook";
        }
        return"redirect:home";
    }

    @GetMapping("/comment")
    public String getComment(@RequestParam String opinion, String bookID){
        Opinions comment = new Opinions();
        comment.setBooksO(bookRepo.findBookById(bookID));
        comment.setOpinion(opinion);
        comment.setUsersO(currentUser);
        opinionsRepo.addOpinion(comment);
        return"redirect:book";
    }
    @PostMapping("/coment")
    public String postCommnet(){
        return "redirect:home";
    }

}
