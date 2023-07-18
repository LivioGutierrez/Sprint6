package cl.sprint.Sprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BienvenidaController {
    @GetMapping("/bienvenida")
    private String bienvenida(){
        return "Bienvenida";
    }
}
