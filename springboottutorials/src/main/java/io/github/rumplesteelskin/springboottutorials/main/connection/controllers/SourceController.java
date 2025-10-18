package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping("source")
public class SourceController {

    @Autowired
    private MyBean myBean;

    @GetMapping("get-bean")
    public String getMyBean() {
        return myBean.getId() + " " + myBean.getName() + " " + myBean.getSalary() + "\n" + myBean.getClass().getName();
    }
}
