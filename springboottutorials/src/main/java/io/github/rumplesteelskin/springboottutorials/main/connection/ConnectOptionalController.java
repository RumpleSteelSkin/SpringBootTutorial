package io.github.rumplesteelskin.springboottutorials.main.connection;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("oconnect")
@RequiredArgsConstructor
public class ConnectOptionalController {

    private final IProductRepository productRepository;

    @GetMapping("find-else/{id}")
    public String findElseById(@PathVariable("id") String id) {
        return productRepository.findById(UUID.fromString(id)).map(product -> "Product: " + product.getName()).orElse("Product not found");
    }

    @GetMapping("find-get/{id}")
    public String findGetById(@PathVariable("id") String id) {
        return productRepository.findById(UUID.fromString(id)).map(product -> "Product: " + product.getName()).orElseGet(() -> {
            String defaultName = "FindGet If Not Found Is Name";
            return "FindGet Response: " + defaultName;
        });
    }

    @GetMapping("find-throw/{id}")
    public String findThrowById(@PathVariable("id") String id) {
        return productRepository.findById(UUID.fromString(id)).map(product -> "Product: " + product.getName()).orElseThrow(() -> new IllegalArgumentException("Product Not Found"));
    }

}
