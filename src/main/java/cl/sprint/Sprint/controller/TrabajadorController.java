package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.entity.InstitucionPrevision;
import cl.sprint.Sprint.entity.InstitucionSalud;
import cl.sprint.Sprint.entity.Trabajador;
import cl.sprint.Sprint.service.IEmpleadorService;
import cl.sprint.Sprint.service.IPrevicionSerive;
import cl.sprint.Sprint.service.ISaludService;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    IPrevicionSerive objPrevisionService;;
    @Autowired
    ISaludService objSaludService;
    @Autowired
    IEmpleadorService objEmpleadorService;


    @GetMapping
    public String listaTrabajador(Model model){
        List<Trabajador>listarTrabajador= objTrabajadorService.listarTrabajador();
        model.addAttribute("trabajador", listarTrabajador);
        return "listaTrabajador";
    }
    //crear
    @GetMapping("/crearTrabajador")
    public String mostrarCrearTrabajador(Model model){
        List<InstitucionPrevision>prevision=objPrevisionService.listarPrevision();
        List<InstitucionSalud>salud=objSaludService.listarSalud();
        List<Empleador>empleador=objEmpleadorService.listarEmpleador();
        model.addAttribute("prevision", prevision);
        model.addAttribute("salud", salud);
        model.addAttribute("empleador", empleador);
        model.addAttribute("trabajador", new Trabajador());
        return "fromTrabajador";
    }
    @PostMapping("/crearTrabajador")
    public String CrearTrabajador(@ModelAttribute Trabajador trabajador,
                                         @RequestParam("previsionId") int previsionId,
                                         @RequestParam("saludId") int saludId,
                                         @RequestParam("id_empleador") int id_empleador){
        InstitucionPrevision prevision= objPrevisionService.buscarPrevisionPorId(previsionId);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(saludId);
        Empleador empleador= objEmpleadorService.buscarEmpleadorPorID(id_empleador);
        trabajador.setId_inst_prevision(prevision);
        trabajador.setId_inst_salud(salud);
        List<Empleador>listaEmpleadores = new ArrayList<>();
        listaEmpleadores.add(empleador);
        trabajador.setListaEmpleador(listaEmpleadores);
        objTrabajadorService.crearTrabajador(trabajador);
        return "redirect:/trabajador";
    }
    //actualizar
    @GetMapping("/{id_trabajador}")
    public String buscarTrabajadorPorID(@PathVariable int id_trabajador, Model model){
        Trabajador trabajador= objTrabajadorService.buscarTrabajadorPorID(id_trabajador);
        model.addAttribute("trabajador", trabajador);
        return "redirect:/trabajador";
    }
    @PostMapping("/editar/{id_trabajador}")
    public String mostrarEditarTrabajador (@PathVariable int id_trabajador, Model model){
        model.addAttribute("trabajador", objTrabajadorService.buscarTrabajadorPorID(id_trabajador));
        List<InstitucionPrevision> prevision = objPrevisionService.listarPrevision();
        List<InstitucionSalud> salud = objSaludService.listarSalud();
        model.addAttribute("prevision", prevision);
        model.addAttribute("salud",salud);
        return "actualizarTrabajador";
    }
    @PostMapping("/actualizar/{id_trabajador}")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @PathVariable int id_trabajador,
                                       @RequestParam("id_inst_prevision") int id_inst_prevision,
                                       @RequestParam("id_inst_salud") int id_inst_salud){
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(id_inst_prevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(id_inst_salud);
        trabajador.setId_inst_prevision(prevision);
        trabajador.setId_inst_salud(salud);
        objTrabajadorService.actualizarTrabajador(trabajador,id_trabajador);
        return "redirect:/trabajador";
    }
    @PostMapping("/eliminar/{id_trabajador}")
    public String elimarTrabajador(@PathVariable int id_trabajador){
        objTrabajadorService.eliminar(id_trabajador);
        return "redirect:/trabajador";
    }
}
