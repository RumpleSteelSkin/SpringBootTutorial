package io.github.rumplesteelskin.module.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationOne {
    @Bean
    BeanOne beanOne() {
        BeanOne beanOne = new BeanOne();
        beanOne.setOneId(401);
        beanOne.setOneName("CoreOne");
        return beanOne;
    }
}
