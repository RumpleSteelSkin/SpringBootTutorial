package io.github.rumplesteelskin.springboottutorials.main.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("singleton")
    MySingletonBean mySingletonBean() {
        return new MySingletonBean();
    }

    @Bean
    @Scope("prototype")
    MyPrototypeBean myPrototypeBean() {
        return new MyPrototypeBean();
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    MyRequestBean myRequestBean() {
        return new MyRequestBean();
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    MySessionBean mySessionBean() {
        return new MySessionBean();
    }

    @Bean
    @Scope(value = "application", proxyMode = ScopedProxyMode.TARGET_CLASS)
    MyApplicationBean myApplicationBean() {
        return new MyApplicationBean();
    }
}
