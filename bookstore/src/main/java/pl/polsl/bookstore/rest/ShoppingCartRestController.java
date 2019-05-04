package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.ShoppingCart;
import pl.polsl.bookstore.repository.ShoppingCartRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {

    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartRestController(ShoppingCartRepository theShoppingCartRepository ){    shoppingCartRepository =  theShoppingCartRepository;  }


    // expose "/shoppingCart" and return list of shoppingCart
    @GetMapping("/shoppingCart")
    public List<ShoppingCart> findAll(){return shoppingCartRepository.findAll();}


}
