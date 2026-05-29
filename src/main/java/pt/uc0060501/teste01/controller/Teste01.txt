package pt.uc0060501.teste01.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Teste01 {
    @GetMapping("/hello")
    public String hello() {
        return "hello uc0060501";
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste01";
    }
    
}
