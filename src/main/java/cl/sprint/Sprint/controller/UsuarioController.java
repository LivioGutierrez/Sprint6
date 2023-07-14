package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.service.IUsuarioServie;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class UsuarioController {
    @GetMapping("/usuario")
    public String usuario() {
        return "fromUsuario";
    }

}
