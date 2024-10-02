package com.example.hw6springcities.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(@RequestParam(name = "main", required = false, defaultValue = "java spring")
                           String main, Model model) {
        model.addAttribute("main", main);

        return "home";
    }
}
