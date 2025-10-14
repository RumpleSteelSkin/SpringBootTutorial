package io.github.rumplesteelskin.springboottutorials.SecondMain;

import io.github.rumplesteelskin.springboottutorials.Main.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("Object")
public class ObjectClient {

    @GetMapping("getCount")
    private int GetCount(){
        String uri = "http://localhost:8080/product/count";
        RestTemplate restTemplate = new RestTemplate();
        int count = restTemplate.getForObject(uri, int.class);
        return count;
    }
    @GetMapping("getProduct")
    private Product GetProduct() {
        String uri = "http://localhost:8080/product/get";
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(uri, Product.class);
        return product;
    }

    @GetMapping("getProducts")
    private List<Product> GetProducts() {
        String uri = "http://localhost:8080/product/getAll";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> entity = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {
        });
        return entity.getBody();
    }
}
