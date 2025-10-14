package io.github.rumplesteelskin.springboottutorials.Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/count")
    public int GetProductCount() {
        return 3;
    }

    @GetMapping("/get")
    public Product GetProduct() {
        return new Product(300, "Mobile Phone", 12345);
    }

    @GetMapping("/getAll")
    public List<Product> GetAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(300, "Mobile Phone", 12345));
        products.add(new Product(301, "Laptop", 232323));
        products.add(new Product(302, "Mouse", 12));
        products.add(new Product(303, "Keyboard", 13));
        products.add(new Product(304, "GamingPad", 51));
        return products;
    }
}
