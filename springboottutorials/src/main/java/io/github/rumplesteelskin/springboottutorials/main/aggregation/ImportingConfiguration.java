package io.github.rumplesteelskin.springboottutorials.main.aggregation;

import io.github.rumplesteelskin.module.one.ConfigurationOne;
import io.github.rumplesteelskin.module.two.ConfigurationTwo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// Path 1
@Import({ConfigurationOne.class, ConfigurationTwo.class})
// Path 2
@ComponentScan(basePackages = {"io.github.rumplesteelskin.module.one", "io.github.rumplesteelskin.module.two"})
public class ImportingConfiguration {
}
