package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Usuario;

import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;

    //Listar
    @GetMapping
    public String listarUsuario(Model model) {
        List<Usuario> listarUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("usuarios",listarUsuarios);
        return "listaUsuario";
    }

    //Crear Usuario
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

/*    //Eliminar Usuario
    @GetMapping("/{id_usuario}/eliminar")
    public String motrarEliminar(@PathVariable int id_usuario, Model model){
        Usuario usuarioEliminar = objUsuarioService.buscarUsuarioPorID(id_usuario);
        model.addAttribute("usuario", usuarioEliminar);
        return "eliminarUsuario";
    }*/

    @PostMapping("/eliminar/{id_usuario}")
    public String eliminarUsuario(@PathVariable int id_usuario){
        objUsuarioService.eliminarUsuario(id_usuario);
        return "redirect:/usuario";
    }

    //Actualizar Usuario
    @GetMapping("/{id_usuario}")
    private String buscarUsuarioPorID(@PathVariable int id_usuario, Model model){
        Usuario usuario = objUsuarioService.buscarUsuarioPorID(id_usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/usuario";
    }
    @PostMapping("/editar/{id_usuario}")
    public String mostrarEditar(@PathVariable int id_usuario, Model model){
        model.addAttribute("usuario", objUsuarioService.buscarUsuarioPorID(id_usuario));
        return "actualizarUsuario";
    }
    @PostMapping("/actualizar/{id_usuario}")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, @PathVariable int id_usuario){
        objUsuarioService.actualizarUsuario(usuario, id_usuario);
        return "redirect:/usuario";
    }

    //Registro Principal

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model){
        return "registrar";
    }
    @PostMapping("/registrar")
    public String registrarUsuario (@ModelAttribute Usuario usuario){
        usuario.setFecha_creacion(LocalDateTime.now());
        objUsuarioService.registrarUsuario(usuario);
        return "redirect:/login";
    }

}
