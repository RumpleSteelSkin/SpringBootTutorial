package io.github.rumplesteelskin.springboottutorials.secondmain.clients;

import io.github.rumplesteelskin.springboottutorials.main.entities.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SuppressWarnings("DataFlowIssue")
@RestController
@RequestMapping("Object")
public class ObjectClient {

    @GetMapping("getCount")
    private int GetCount() {
        String uri = "http://localhost:8080/product/count";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, int.class);
    }

    @GetMapping("getProduct")
    private Product GetProduct() {
        String uri = "http://localhost:8080/product/get";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Product.class);
    }

    @GetMapping("getProducts")
    private List<Product> GetProducts() {
        String uri = "http://localhost:8080/product/getAll";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> entity = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {
        });
        return entity.getBody();
    }

    @GetMapping("postWriting")
    private void postWriting() {
        String uri = "http://localhost:8080/writing/product";
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product(120, "Book", 23);
        //restTemplate.postForObject(uri, product, Long.class);
        ResponseEntity<Long> entity = restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(product), Long.class);
        System.out.println("Id : " + entity.getBody());
    }


    @GetMapping("putWriting")
    private void putWriting() {
        String uri = "http://localhost:8080/writing/product";
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product(120, "Book", 23);
        restTemplate.exchange(uri, HttpMethod.PUT, new HttpEntity<>(product), Void.class);
    }


    @GetMapping("deleteWriting")
    private void deleteWriting() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product(120, "Book", 23);
        String uri = "http://localhost:8080/writing/product/" + product.getId();
        restTemplate.exchange(uri, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
    }


}
