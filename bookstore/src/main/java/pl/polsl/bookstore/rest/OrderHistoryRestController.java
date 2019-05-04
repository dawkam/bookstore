package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.OrderHistory;
import pl.polsl.bookstore.repository.OrderHistoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderHistoryRestController {

    private OrderHistoryRepository orderHistoryRepository;

    @Autowired
    public OrderHistoryRestController(OrderHistoryRepository theOrderHistoryRepository ){    orderHistoryRepository =  theOrderHistoryRepository;  }


    // expose "/orderHistory" and return list of orderHistory
    @GetMapping("/orderHistory")
    public List<OrderHistory> findAll(){return orderHistoryRepository.findAll();}


}
