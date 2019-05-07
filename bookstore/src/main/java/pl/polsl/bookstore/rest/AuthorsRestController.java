package pl.polsl.bookstore.rest;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import pl.polsl.bookstore.entity.Authors;
        import pl.polsl.bookstore.repository.AuthorsRepository;

        import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorsRestController {

    private AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsRestController(AuthorsRepository theAuthorsRepository ){    authorsRepository =  theAuthorsRepository;  }


    // expose "/authors" and return list of authors
    @GetMapping("/authors")
    public List<Authors> findAll(){return authorsRepository.findAll();}


}
