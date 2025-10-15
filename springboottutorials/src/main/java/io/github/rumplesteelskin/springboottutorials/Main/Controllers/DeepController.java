package io.github.rumplesteelskin.springboottutorials.Main.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deep")
public class DeepController {
    @RequestMapping(value = "/randBig", method = RequestMethod.GET)
    public String GetRandomBig(){
        return "Deep Big Random:" + (int)(Math.random() * 100);
    }
}
