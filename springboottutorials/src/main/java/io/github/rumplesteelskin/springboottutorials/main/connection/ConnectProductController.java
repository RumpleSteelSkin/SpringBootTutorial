package io.github.rumplesteelskin.springboottutorials.main.connection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("connection")
public class ConnectProductController {

    private final IProductRepository productRepository;

    public ConnectProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("create/{name}/{price}")
    public String create(@PathVariable("name") String name, @PathVariable("price") double price) {
        UUID id = UUID.randomUUID();
        Product product = new Product(id, price, name);
        productRepository.save(product);
        return product.toString();

    }

    @GetMapping("find/{id}")
    public Product findById(@PathVariable("id") UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("find2/{id}")
    public String findById2(@PathVariable("id") UUID id) {
        UUID uuid = UUID.fromString(id.toString());
        Optional<Product> product = productRepository.findById(uuid);
        if (product.isPresent()) {
            Product p = product.get();
            return "Product " + p.getName() + " " + p.getPrice();
        } else return "Product " + id + " not found";
    }

    @GetMapping("get-all")
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("generate")
    public String generate() {
        int count = 10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            UUID uuid = UUID.randomUUID();
            Product product = new Product(uuid, 4000 + i * 500, "Product " + i);
            productRepository.save(product);
            stringBuilder.append(product.getId()).append(" ").append(product.getName()).append(" ").append(product.getPrice()).append("\n");
        }
        return "Generated (" + count + "):" + stringBuilder;
    }

    @GetMapping("exist/{id}")
    public boolean exist(@PathVariable("id") UUID id) {
        return productRepository.existsById(id);
    }

    @GetMapping("count")
    public int count() {
        return (int) productRepository.count();
    }

    @GetMapping("update/{id}/{name}/{price}")
    public String create(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("price") double price) {
        UUID uuid = UUID.fromString(id);
        Optional<Product> product = productRepository.findById(uuid);
        if (product.isPresent()) {
            Product p = product.get();
            p.setName(name);
            p.setPrice(price);
            productRepository.save(p);
            return "Product " + p.getName() + " " + p.getPrice();
        } else return "Product " + id + " not found";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        productRepository.deleteById(id);
        return "Product " + id + " deleted";
    }

}
