package cl.sprint.Sprint.rescontroller;

import cl.sprint.Sprint.entity.Trabajador;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trabajador")
public class TrabajadorRestController {
    @Autowired
    ITrabajadorService objTrabajadorService;

    @GetMapping//completar
    public List<Trabajador> listaTrabajadores(){
        return objTrabajadorService.listarTrabajador();
    }

    @GetMapping("/{id_trabajador}")
    public Trabajador buscarTrabajador(@PathVariable int id_trabajador){
        return objTrabajadorService.buscarTrabajadorPorID(id_trabajador);
    }
}
