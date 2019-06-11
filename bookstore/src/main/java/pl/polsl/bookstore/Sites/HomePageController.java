package pl.polsl.bookstore.Sites;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.bookstore.entity.*;
import pl.polsl.bookstore.profit.ProfitPerAuthor;
import pl.polsl.bookstore.profit.ProfitPerBook;
import pl.polsl.bookstore.profit.ProfitPerMonth;
import pl.polsl.bookstore.repository.*;

import java.util.Iterator;
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

    @Autowired
    public HomePageController(BookAuthorRepository theBookAuthorRepo, BooksRepository theBookRepo, BookFormatRepository theBookFormatRepo, AuthorsRepository theAuthorsRepo, UsersRepository theUsersRepo, ShoppingCartRepository theShoppingCartRepo, OrderHistoryRepository theOrderHistoryRepo, OpinionsRepository theOpinionsRepo, RoleRepository theRoleRepo, WarehouseRepository theWarehouseRepo) {
        bookRepo = theBookRepo;
        bookFormatRepo = theBookFormatRepo;
        bookAuthorRepo = theBookAuthorRepo;
        authorsRepo = theAuthorsRepo;
        usersRepo = theUsersRepo;
        shoppingCartRepo = theShoppingCartRepo;
        orderHistoryRepo = theOrderHistoryRepo;
        opinionsRepo = theOpinionsRepo;
        roleRepo = theRoleRepo;
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
    public String postLogin(@RequestParam String login, String password, Model model) {
        for (Users user : usersRepo.findAll()) {
            if (login.equals(user.getLogin())) {
                if (password.equals(user.getPassword())) {
                    currentUser = user;
                    return "redirect:home";
                } else {
                    model.addAttribute("error", "Błedny login lub hasło"); // do pliku jsp jest przesyłana treść błędu
                    return "login";
                }
            }
        }
        model.addAttribute("error", "Błedny login lub hasło"); // do pliku jsp jest przesyłana treść błędu

        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        if (currentUser != null)
            return "redirect:home";
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String login, String password, String passwordConfirm, String name, String surname, String nation, String city, String street, String email, Model model) {
        Users tmpUser = new Users(login, password, name, surname, nation, city, street, email, null);
        //walidacja loginu
        for (Users user : usersRepo.findAll()) {
            if (login.equals(user.getLogin())) {
                model.addAttribute("user", tmpUser);
                model.addAttribute("passwordConfirm", passwordConfirm);
                model.addAttribute("error", "Login jest już zajęty"); // do pliku jsp jest przesyłana treść błędu
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
                    Users user = new Users(login, password, name, surname, nation, city, street, email, roleRepo.findRole("user"));
                    user = usersRepo.registerUser(user);
                    return "redirect:login";

                } catch (Exception e) {
                    model.addAttribute("error", "Błedne dane");// do pliku jsp jest przesyłana treść błędu
                    model.addAttribute("user", tmpUser);
                    model.addAttribute("passwordConfirm", passwordConfirm);
                    return "register";
                }
            } else {
                model.addAttribute("error", "Błędny email");// do pliku jsp jest przesyłana treść błędu
                model.addAttribute("user", tmpUser);
                model.addAttribute("passwordConfirm", passwordConfirm);
                return "register";
            }
        } else {
            model.addAttribute("user", tmpUser);
            model.addAttribute("passwordConfirm", passwordConfirm);
            model.addAttribute("error", "Hasła się nie zgadzają");// do pliku jsp jest przesyłana treść błędu
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
    public String getShoppingCart(@RequestParam(defaultValue = "") String formatKsiazki, @RequestParam(defaultValue = "") String warehouseidPaper, @RequestParam(defaultValue = "") String warehouseidEbook, @RequestParam(defaultValue = "") String warehouseidAudiobook, Model model) {
        if (currentUser == null)
            return "redirect:login";
        if (!formatKsiazki.equals("")) {
            try {
                ShoppingCart cart = new ShoppingCart();
                cart.setQuantity(1);
                cart.setUsersSh(currentUser);
                if (!warehouseidPaper.equals("") && formatKsiazki.equals("papier"))
                    cart.setWarehouseSh(warehouseRepo.findWarehouseById(Long.parseLong(warehouseidPaper)));
                if (!warehouseidPaper.equals("") && formatKsiazki.equals("ebook"))
                    cart.setWarehouseSh(warehouseRepo.findWarehouseById(Long.parseLong(warehouseidEbook)));
                if (!warehouseidPaper.equals("") && formatKsiazki.equals("audiobook"))
                    cart.setWarehouseSh(warehouseRepo.findWarehouseById(Long.parseLong(warehouseidAudiobook)));
                shoppingCartRepo.updateShoppingCart(cart);
                currentUser.addBookToShoppingCart(cart);
            } catch (Exception e) {
                return "redirect:shoppingCart";
            }
        }

        model.addAttribute("user", currentUser);

        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/changeQuantity")
    public String postShoppingCartChangeQuantity(@RequestParam long idWarehouse, String quantity, Model model) {
        if (!quantity.equals("")) {

            shoppingCartRepo.updateShoppingCartQuantity(idWarehouse, currentUser.getIdUser(), Integer.valueOf(quantity));
            ShoppingCart tmp;
            for (ShoppingCart shoppingcart : currentUser.getShoppingCart()) {
                if (shoppingcart.getWarehouseSh().getIdBookWarehouse() == idWarehouse) {
                    tmp = shoppingcart;
                    tmp.setQuantity(Integer.valueOf(quantity));
                }
            }
        }
        model.addAttribute("user", currentUser);
        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/deleteBook")
    public String postShoppingCartDeleteBook(@RequestParam long idWarehouse, Model model) {
        shoppingCartRepo.deleteBookFromShoppingCart(idWarehouse, currentUser.getIdUser());
        ShoppingCart tmp = new ShoppingCart();
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
    public String postShoppingCartPay(Model model) {
        Iterator iterator = currentUser.getShoppingCart().iterator();
        ShoppingCart shoppingcart = new ShoppingCart();
        while (iterator.hasNext()) {
            shoppingcart = (ShoppingCart) iterator.next();
            try {
                if(shoppingcart.getWarehouseSh().getBookFormatW().getBookFormat().equals("książka"))
                shoppingCartRepo.reduceQuantityWarehouse(shoppingcart.getWarehouseSh().getIdBookWarehouse(), shoppingcart.getWarehouseSh().getQuantity() - shoppingcart.getQuantity());
            } catch (Exception e) {
                model.addAttribute("error", "Brak książki "+ shoppingcart.getWarehouseSh().getBooksW().getFullName());// do pliku jsp jest przesyłana treść błędu
                model.addAttribute("user", currentUser);
                return "shoppingCart";
            }
            orderHistoryRepo.addOrderHistory(shoppingcart.getWarehouseSh(), currentUser, shoppingcart.getQuantity(), shoppingcart.getWarehouseSh().calculatePrice(shoppingcart.getQuantity()));
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
        String opinion = "";
        for (Opinions op : book.getOpinions()) {
            if (currentUser != null && op.getUsersO().getIdUser() == currentUser.getIdUser()) {
                opinion = op.getOpinion();
            }
        }
        model.addAttribute("userOpinion", opinion);
        model.addAttribute("bookSelected", book);
        model.addAttribute("paperFormat", null);
        model.addAttribute("eBookFormat", null);
        model.addAttribute("audiobookFormat", null);
        for (Books tmpBook : bookRepo.findAll()) {
            List<Books> tmp0 = bookRepo.findAll();
            String tmp1 = Long.toString(tmpBook.getIdBook());
            String tmp2 = tmpBook.getWarehouse().get(0).getBookFormatW().getBookFormat();
            if (Long.toString(tmpBook.getIdBook()).equals(bookId))
                for (Warehouse wh : tmpBook.getWarehouse()) {
                    if (wh.getBookFormatW().getBookFormat().equals("książka")) {
                        model.addAttribute("paperFormat", "True");
                        model.addAttribute("bookPricePaper", wh.getPrice());
                        model.addAttribute("warehousePaper", wh.getIdBookWarehouse());
                    }
                    if (wh.getBookFormatW().getBookFormat().equals("e-book")) {
                        model.addAttribute("eBookFormat", "True");
                        model.addAttribute("bookPriceEbook", wh.getPrice());
                        model.addAttribute("warehouseEbook", wh.getIdBookWarehouse());
                    }
                    if (wh.getBookFormatW().getBookFormat().equals("audiobook")) {
                        model.addAttribute("audiobookFormat", "True");
                        model.addAttribute("bookPriceAudiobook", wh.getPrice());
                        model.addAttribute("warehouseAudiobook", wh.getIdBookWarehouse());
                    }
                }
        }
        return "book";
    }

    @GetMapping("/newBook")
    public String getNewBook() {
        if (currentUser == null)
            return "redirect:home";
        if (currentUser.getRoleU().getRole().equals("worker"))
            return "newBook";
        else {
            return "redirect:home";
        }
    }

    @PostMapping("/newBook")
    public String postNewBook(@RequestParam String title, String name, String surname, String cover, String type, double purchasePrize, double prize, double discount, long quantity, String description, String genre, long pages) {
        try {

            Books book = new Books(title, genre, pages, cover, description);
            book = bookRepo.findBook(book);
            bookRepo.addBook(book);

            Authors author = authorsRepo.findAuthor(name, surname);
            authorsRepo.addAuthor(author);

            BookAuthor bookAuthor = bookAuthorRepo.findBookAuthor(book, author);
            bookAuthorRepo.addBookAuthor(bookAuthor);

            Warehouse warehouse = new Warehouse(book, bookFormatRepo.findByName(type), prize, discount, quantity, purchasePrize);
            warehouse = warehouseRepo.findWarehouse(warehouse);
            warehouseRepo.addWarehouse(warehouse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:newBook";
        }
        return "redirect:home";
    }

    @GetMapping("/comment")
    public String getComment(@RequestParam String opinion, String bookID) {
        if (currentUser == null)
            return "redirect:home";
        Opinions comment = new Opinions();
        comment.setBooksO(bookRepo.findBookById(bookID));
        comment.setOpinion(opinion);
        comment.setUsersO(currentUser);
        try {
            opinionsRepo.addOpinion(comment);
        } catch (Exception e) {
            try {
                opinionsRepo.updateOpinion(comment);
            } catch (Exception ex) {
                return "redirect:book?bookId=" + bookID;
            }
            return "redirect:book?bookId=" + bookID;
        }
        return "redirect:book?bookId=" + bookID;
    }

    @PostMapping("/comment")
    public String postCommnet() {
        if (currentUser == null || !currentUser.getRoleU().getRole().equals("worker"))
            return "redirect:home";
        return "redirect:home";
    }

    @GetMapping("/report")
    public String getReport(@RequestParam long userId, long bookId) {
        if (currentUser == null)
            return "redirect:home";
        Opinions opinions = opinionsRepo.findOpinionByIds(userId, bookId);
        opinionsRepo.updateReported(opinions);
        return "redirect:home";
    }

    @GetMapping("/reported")
    public String getReported(Model model) {
        if (currentUser == null)
            return "redirect:home";
        if (currentUser.getRoleU().getRole().equals("worker")) {
            List<Opinions> opinions = opinionsRepo.findReported();
            model.addAttribute("opinions", opinions);
            return "reported";
        } else {
            return "redirect:home";
        }
    }

    @PostMapping("/reported")
    public String postReported(@RequestParam Model model) {
        List<Opinions> opinions = opinionsRepo.findReported();
        model.addAttribute("opinions", opinions);

        return "reported";
    }

    @GetMapping("/block")
    public String getBlock(@RequestParam long userId) {
        if (currentUser == null || !currentUser.getRoleU().getRole().equals("worker"))
            return "redirect:home";
        usersRepo.findById(userId).setAccessToComments(false);
        opinionsRepo.deleteUsersOpinions(usersRepo.findById(userId));
        return "redirect:home";
    }

    @GetMapping("/deleteComment")
    public String getDeleteComment(@RequestParam long userId, long bookId) {
        if (currentUser == null || !currentUser.getRoleU().getRole().equals("worker"))
            return "redirect:home";
        opinionsRepo.deleteOpinion(opinionsRepo.findOpinionByIds(userId, bookId));
        return "redirect:home";
    }


    @GetMapping("/profit")
    public String getProfit(Model model) {
//        if (currentUser == null)
//            return "redirect:login";
        List<ProfitPerMonth> profitPerMonth = orderHistoryRepo.getProfitPerMonth();
        List<ProfitPerBook> profitPerBook = orderHistoryRepo.getProfitPerBook();
        List<ProfitPerAuthor> profitPerAuthor = orderHistoryRepo.getProfitPerAuthor();
        model.addAttribute("profitPerMonth", profitPerMonth);
        model.addAttribute("profitPerBook", profitPerBook);
        model.addAttribute("profitPerAuthor", profitPerAuthor);
        return "profit";
    }

    @PostMapping("/profit")
    public String postProfit() {
        return "profit";
    }


}
