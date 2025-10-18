package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;

import io.github.rumplesteelskin.springboottutorials.main.connection.concretes.MyAgent;
import io.github.rumplesteelskin.springboottutorials.main.connection.concretes.MyBean;
import io.github.rumplesteelskin.springboottutorials.main.connection.interfaces.MySpec;
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
    @Autowired
    private MySpec mySpec;
    @Autowired
    private MyAgent myAgent;

    @GetMapping("get-bean")
    public String getMyBean() {
        return myBean.getId() + " " + myBean.getName() + " " + myBean.getSalary() + "\n" + myBean.getClass().getName();
    }

    @GetMapping("get-spec")
    public String getMySpec() {
        return mySpec.myMethod("Input") + "\n" + mySpec.getClass().getName();
    }

    @GetMapping("get-agent")
    public String getMyAgent() {
        return myAgent.getName() + " " + myAgent.getMyBean().getName() + "\n" + myAgent.getClass().getName();
    }
}
