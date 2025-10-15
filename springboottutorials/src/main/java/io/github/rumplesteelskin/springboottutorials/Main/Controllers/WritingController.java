package io.github.rumplesteelskin.springboottutorials.Main.Controllers;

import io.github.rumplesteelskin.springboottutorials.Main.DTOs.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("writing")
public class WritingController {
    @PostMapping("product")
    public long postProduct(@RequestBody Product product) {
        System.out.println("Post Product: " + product.getId() + " " + product.getName() + " " + product.getPrice());
        product.setId(444);
        return product.getId();
    }

    @PutMapping("product")
    public void putProduct(@RequestBody Product product) {
        System.out.println("Put Product: " + product.getId() + " " + product.getName() + " " + product.getPrice());
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable(name = "id") long productId) {
        System.out.println("Delete Product:: " + productId);
    }
}
