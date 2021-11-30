package ru.samsung;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String index() {
        System.out.println("Тест логов");
        return "Привет, мир!";
    }
}