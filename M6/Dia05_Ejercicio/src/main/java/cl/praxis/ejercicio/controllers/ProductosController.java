package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.entities.Product;
import cl.praxis.ejercicio.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supermarket")
public class ProductosController {

    @Autowired
    public IProductService iProductService;

    @GetMapping
    public List<Product> getAllProducts() {
        return iProductService.getAllProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        iProductService.addProduct(product);
    }
}
