package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    String text ;

    public WelcomeController(@Value("${WELCOME_MESSAGE}") String text) {
        this.text =text;
    }

    @GetMapping("/")
    public String sayHello() {
        return text;
    }
}