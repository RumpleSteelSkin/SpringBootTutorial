package io.github.rumplesteelskin.springboottutorials.secondmain.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("header")
public class HeaderClient {
    private final String uri = "http://localhost:8080/transfer/";
    private final RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> entity;

    @GetMapping("get-header")
    public void getHeader() {
        entity = restTemplate.exchange(uri + "setHeader", HttpMethod.GET, HttpEntity.EMPTY, String.class);
        System.out.println("Body : " + entity.getBody());
        System.out.println("Headers : " + entity.getHeaders());
        System.out.println("Header Input : " + entity.getHeaders().getFirst("input"));
    }

    @GetMapping("get-cookie")
    public void getCookie() {
        entity = restTemplate.exchange(uri + "setCookie", HttpMethod.GET, HttpEntity.EMPTY, String.class);
        System.out.println("Body : " + entity.getBody());
        System.out.println("Headers : " + entity.getHeaders());
        System.out.println("Header Cookie : " + entity.getHeaders().getFirst(HttpHeaders.SET_COOKIE));
    }

    @GetMapping("set-header")
    public void setHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("input", "Client To Server Header");
        HttpEntity<String> request = new HttpEntity<>("This is a Body", headers);
        entity = restTemplate.exchange(uri + "getHeader", HttpMethod.GET, request, String.class);
        System.out.println("Body : " + entity.getBody());
    }

    @GetMapping("set-cookie")
    public void setCookie() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, "Client To Server Cookie");
        HttpEntity<String> request = new HttpEntity<>("This is a Body", headers);
        entity = restTemplate.exchange(uri + "getCookie", HttpMethod.GET, request, String.class);
        System.out.println("Body : " + entity.getBody());
    }

}
