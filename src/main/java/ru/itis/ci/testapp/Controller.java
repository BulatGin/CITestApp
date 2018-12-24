package ru.itis.ci.testapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bulat Giniyatullin
 * 16 December 2018
 */

@RestController
public class Controller {
    @GetMapping("")
    public String index() {
        return "I am working!!!!!!!!!";
    }
}
