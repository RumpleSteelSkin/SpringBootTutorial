package io.github.rumplesteelskin.springboottutorials.main.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transfer")
public class TransferController {

    @GetMapping("setHeader")
    public ResponseEntity<?> setHeader() {
        return ResponseEntity
                .ok()
                .header("input", "This is header.")
                .body("Header is set");
    }


    @GetMapping("setCookie")
    public ResponseEntity<?> setCookie() {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, "This is cookie.")
                .body("Cookie is set");
    }


    @GetMapping("getHeader")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "Default Value Of Header") String input) {
        return ResponseEntity.ok("Coming->>> " + input);
    }

    @GetMapping("getCookie")
    public ResponseEntity<?> getCookie(@RequestHeader(value = HttpHeaders.SET_COOKIE, defaultValue = "Default Value Of Cookie") String input) {
        return ResponseEntity.ok("Coming->>> " + input);
    }


}
