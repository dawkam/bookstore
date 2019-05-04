package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.Opinions;
import pl.polsl.bookstore.repository.OpinionsRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OpinionsRestController {

    private OpinionsRepository opinionsRepository;

    @Autowired
    public OpinionsRestController(OpinionsRepository theOpinionsRepository ){    opinionsRepository =  theOpinionsRepository;  }


    // expose "/opinions" and return list of opinions
    @GetMapping("/opinions")
    public List<Opinions> findAll(){return opinionsRepository.findAll();}


}
