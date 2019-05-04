package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.Users;
import pl.polsl.bookstore.repository.UsersRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersRestController {

    private UsersRepository usersRepository;

    @Autowired
    public UsersRestController(UsersRepository theUsersRepository ){    usersRepository =  theUsersRepository;  }


    // expose "/users" and return list of users
    @GetMapping("/users")
    public List<Users> findAll(){return usersRepository.findAll();}


}
