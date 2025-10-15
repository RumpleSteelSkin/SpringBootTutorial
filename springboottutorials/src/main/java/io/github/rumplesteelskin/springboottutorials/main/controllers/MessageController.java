package io.github.rumplesteelskin.springboottutorials.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/rand")
    public double GetRandom(){
        return Math.random();
    }

    @RequestMapping(value = "/randBig", method = RequestMethod.GET)
    public int GetRandomBig(){
        return (int)(Math.random() * 100);
    }
}
