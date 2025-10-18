package io.github.rumplesteelskin.springboottutorials.main.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scope")
public class ScopeController {

    private final MySingletonBean singletonBean1;
    private final MySingletonBean singletonBean2;
    private final MyPrototypeBean prototypeBean1;
    private final MyPrototypeBean prototypeBean2;
    private final ObjectFactory<MyRequestBean> requestBeanFactory;
    private final ObjectFactory<MySessionBean> sessionBeanFactory;
    private final ObjectFactory<MyApplicationBean> applicationBeanFactory;

    public ScopeController(
            MySingletonBean singletonBean1,
            MySingletonBean singletonBean2,
            MyPrototypeBean prototypeBean1,
            MyPrototypeBean prototypeBean2,
            ObjectFactory<MyRequestBean> requestBeanFactory,
            ObjectFactory<MySessionBean> sessionBeanFactory,
            ObjectFactory<MyApplicationBean> applicationBeanFactory) {

        this.singletonBean1 = singletonBean1;
        this.singletonBean2 = singletonBean2;
        this.prototypeBean1 = prototypeBean1;
        this.prototypeBean2 = prototypeBean2;
        this.requestBeanFactory = requestBeanFactory;
        this.sessionBeanFactory = sessionBeanFactory;
        this.applicationBeanFactory = applicationBeanFactory;
    }

    @GetMapping("all")
    public String getAll() {
        MyRequestBean requestBean1 = requestBeanFactory.getObject();
        MyRequestBean requestBean2 = requestBeanFactory.getObject();
        MySessionBean sessionBean1 = sessionBeanFactory.getObject();
        MySessionBean sessionBean2 = sessionBeanFactory.getObject();
        MyApplicationBean applicationBean1 = applicationBeanFactory.getObject();
        MyApplicationBean applicationBean2 = applicationBeanFactory.getObject();

        return "Singleton 1: " + singletonBean1.getMyValue() +
                "\nSingleton 2: " + singletonBean2.getMyValue() +
                "\nPrototype 1: " + prototypeBean1.getMyValue() +
                "\nPrototype 2: " + prototypeBean2.getMyValue() +
                "\nRequest 1: " + requestBean1.getMyValue() +
                "\nRequest 2: " + requestBean2.getMyValue() +
                "\nSession 1: " + sessionBean1.getMyValue() +
                "\nSession 2: " + sessionBean2.getMyValue() +
                "\nApplication 1: " + applicationBean1.getMyValue() +
                "\nApplication 2: " + applicationBean2.getMyValue();
    }
}
