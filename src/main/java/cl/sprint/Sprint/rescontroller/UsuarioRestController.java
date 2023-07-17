package cl.sprint.Sprint.rescontroller;

import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;
    @GetMapping
    public List<Usuario>listarUsuario(){
        return objUsuarioService.listarUsuario();
    }


}
