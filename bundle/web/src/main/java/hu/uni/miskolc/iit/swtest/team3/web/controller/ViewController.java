package hu.uni.miskolc.iit.swtest.team3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/hellospring")
    public String homeView() {
        return "hellospring";
    }

}
