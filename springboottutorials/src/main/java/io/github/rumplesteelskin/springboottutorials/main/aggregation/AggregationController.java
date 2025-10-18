package io.github.rumplesteelskin.springboottutorials.main.aggregation;

import io.github.rumplesteelskin.module.one.BeanOne;
import io.github.rumplesteelskin.module.two.BeanTwo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aggregation")
public class AggregationController {

    private final BeanOne beanOne;
    private final BeanTwo beanTwo;

    public AggregationController(BeanOne beanOne, BeanTwo beanTwo) {
        this.beanOne = beanOne;
        this.beanTwo = beanTwo;
    }

    @GetMapping("one")
    public String getOne() {
        return "Core 1 : " + beanOne.getOneId() + " " + beanTwo.getTwoName();
    }

    @GetMapping("two")
    public String getTwo() {
        return "Core 2 : " + beanTwo.getTwoId() + " " + beanTwo.getTwoName();
    }


}
