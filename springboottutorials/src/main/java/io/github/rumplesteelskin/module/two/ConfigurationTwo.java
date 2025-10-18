package io.github.rumplesteelskin.module.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTwo {
    @Bean
    BeanTwo beanTwo() {
        BeanTwo beanTwo = new BeanTwo();
        beanTwo.setTwoId(313);
        beanTwo.setTwoName("CoreTwo");
        return beanTwo;
    }
}
