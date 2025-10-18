package io.github.rumplesteelskin.springboottutorials.main.connection.configurations;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SourceConfiguration {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.id = 1;
        myBean.name = "MyBean";
        myBean.salary = 1000;
        return myBean;
    }
}
