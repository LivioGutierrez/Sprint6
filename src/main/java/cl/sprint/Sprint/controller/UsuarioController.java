package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Usuario;

import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;
    @GetMapping
    public String listarUsuario(Model model) {
        List<Usuario> listarUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("usuarios",listarUsuarios);
        return "listaUsuario";
    }

    @GetMapping("/crearUsuario")
    public String mostrarCrearUsuario(Model model){
        return "fromUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario (@ModelAttribute Usuario usuario){
        usuario.setFecha_creacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

}
