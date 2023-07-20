package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.service.IEmpleadorService;
import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    IUsuarioService objUsuarioService;

    //Listar Empleador
    @GetMapping
    public String mostrarEmpleadores(Model model){
        List<Empleador> listarEmpleador = objEmpleadorService.listarEmpleador();
        model.addAttribute("empleadores", listarEmpleador);
        return "listaEmpleador";
    }
    //Crear Empleador
    @GetMapping("/crearEmpleador")
    public String mostrarEmpleador(Model model){
        List<Usuario> usuarios = objUsuarioService.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("empleador", new Empleador());
        return "fromEmpleador";
    }
    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador, @RequestParam("usuarioId") int usuarioId){
        Usuario usuario = objUsuarioService.buscarUsuarioPorID(usuarioId);
        empleador.setUsuario(usuario);
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador";
    }

    //Actualizar Empleador
    @GetMapping("/{id_empleador}")
    public String buscarEmpleador(@PathVariable int id_empleador, Model model){
        Empleador empleador = objEmpleadorService.buscarEmpleadorPorID(id_empleador);
        model.addAttribute("empleador", empleador);
        return "redirect:/empleador";
    }
    @PostMapping("/editar/{id_empleador}")
    public String mostrarEmpleador(@PathVariable int id_empleador, Model model) {
        model.addAttribute("empleador", objEmpleadorService.buscarEmpleadorPorID(id_empleador));
        List<Usuario> usuarios = objUsuarioService.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        return "actualizarEmpleado";
    }
    @PostMapping("/actualizar/{id_empleador}")
    public String actualizarEmpleador(@ModelAttribute Empleador empleador, @PathVariable int id_empleador, @RequestParam("usuarioId") int usuarioId) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorID(usuarioId);
        empleador.setUsuario(usuario);
        objEmpleadorService.actualizarEmpleador(empleador, id_empleador);
        return "redirect:/empleador";
    }
    @PostMapping("/eliminar/{id_empleador}")
    public String eliminarEmpleadorPorId(@PathVariable int id_empleador) {
        objEmpleadorService.eliminar(id_empleador);
        return "redirect:/empleador";
    }
}
