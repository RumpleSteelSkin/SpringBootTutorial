package io.github.rumplesteelskin.springboottutorials.main.connection.configurations;

import io.github.rumplesteelskin.springboottutorials.main.connection.concretes.MyAgent;
import io.github.rumplesteelskin.springboottutorials.main.connection.concretes.MySpecImpl;
import io.github.rumplesteelskin.springboottutorials.main.connection.concretes.MyBean;
import io.github.rumplesteelskin.springboottutorials.main.connection.interfaces.MySpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SourceConfiguration {

    @Bean(initMethod = "initializeBean", destroyMethod = "finalizeBean")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.id = 1;
        myBean.name = "MyBean";
        myBean.salary = 1000;
        return myBean;
    }

    @Bean
    MySpec mySpec() {
        return new MySpecImpl();
    }

    @Bean
    MyAgent myAgent() {
        MyAgent myAgent = new MyAgent();
        myAgent.setName("Agent");
        myAgent.setMyBean(myBean());
        return myAgent;
    }
}
