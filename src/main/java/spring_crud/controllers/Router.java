package spring_crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Router {

    @GetMapping(value = "/")
    public String showMenu() {
        return "index";
    }
}
