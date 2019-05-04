package pl.polsl.bookstore.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.bookstore.entity.Warehouse;
import pl.polsl.bookstore.repository.WarehouseRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseRestController {

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseRestController(WarehouseRepository theWarehouseRepository ){    warehouseRepository =  theWarehouseRepository;  }


    // expose "/warehouse" and return list of warehouse
    @GetMapping("/warehouse")
    public List<Warehouse> findAll(){return warehouseRepository.findAll();}


}
