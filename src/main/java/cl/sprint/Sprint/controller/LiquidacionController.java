package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.InstitucionPrevision;
import cl.sprint.Sprint.entity.InstitucionSalud;
import cl.sprint.Sprint.entity.Liquidacion;
import cl.sprint.Sprint.entity.Trabajador;
import cl.sprint.Sprint.service.ILiquidicionService;
import cl.sprint.Sprint.service.IPrevicionSerive;
import cl.sprint.Sprint.service.ISaludService;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {
    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    ISaludService objSaludService;
    @Autowired
    IPrevicionSerive objPrevisionService;
    @Autowired
    ILiquidicionService objLiquidacionService;

    @GetMapping
    public String ListaLiquicion(Model model){
        List<Liquidacion> listaLiquidaciones = objLiquidacionService.listarLiquidaciones();
        model.addAttribute("liquidaciones", listaLiquidaciones);
        return "listaLiquidacion";
    }
    @GetMapping("/crearLiquidacion")
        public String mostrasLiquidacion(Model model){
        List<Trabajador> trabajador = objTrabajadorService.listarTrabajador();
        List<InstitucionSalud> salud = objSaludService.listarSalud();
        List<InstitucionPrevision> prevision = objPrevisionService.listarPrevision();
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("salud", salud);
        model.addAttribute("prevision", prevision);
        model.addAttribute("liquidacion", new Liquidacion());
        return "fromLiquidacion";
    }
    @PostMapping("/crearLiquidacion")
    public String crearLiquidacion (@ModelAttribute Liquidacion liquidacion,
                                    @RequestParam("id_trabajador") int id_trabajador,
                                    @RequestParam("saludId") int id_inst_salud,
                                    @RequestParam("previsionId") int id_inst_prevision,
                                    Model model){
        liquidacion.setPeriodo(LocalDate.now());
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorID(id_trabajador);
        InstitucionPrevision prevision= objPrevisionService.buscarPrevisionPorId(id_inst_prevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(id_inst_salud);
        liquidacion.setTrabajador(trabajador);
        liquidacion.setId_Inst_Salud(salud);
        liquidacion.setId_Inst_previsional(prevision);
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("salud", salud);
        model.addAttribute("prevision",prevision);
        objLiquidacionService.crearLiquidacion(liquidacion);
        return "redirect:/liquidacion";
    }

    @GetMapping("/{id_liquidacion}")
    public String buscarLiquidacion (@PathVariable int id_liquidacion, Model model){
        Liquidacion liquidacion = objLiquidacionService.buscarLiquidacion(id_liquidacion);
        model.addAttribute("liquidacion", liquidacion);
        return "redirect:/liquidacion";
    }

    @PostMapping("/editar/{id_liquidacion}")
    public String actualizarLiquidacion (@PathVariable int id_liquidacion, Model model){
        model.addAttribute("liquidacion", objLiquidacionService.buscarLiquidacion(id_liquidacion));
        List<InstitucionPrevision> prevision = objPrevisionService.listarPrevision();
        List<InstitucionSalud> salud = objSaludService.listarSalud();
        List<Trabajador> trabajador = objTrabajadorService.listarTrabajador();
        model.addAttribute("prevision", prevision);
        model.addAttribute("salud",salud);
        model.addAttribute("trabajador", trabajador);
        return "actualizarLiquidacion";
    }
    @PostMapping("/actualizar/{id_liquidacion}")
    private String actualizarTrabajador (@ModelAttribute Liquidacion liquidacion, @PathVariable int id_liquidacion,
                                         @RequestParam("previsionID")int id_inst_prevision,
                                         @RequestParam("saludID")int id_inst_salud,
                                         @RequestParam("trabajadorID")int id_trabajador){
        InstitucionPrevision prevision = objPrevisionService.buscarPrevisionPorId(id_inst_prevision);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(id_inst_salud);
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorID(id_trabajador);
        liquidacion.setTrabajador(trabajador);
        liquidacion.setId_Inst_previsional(prevision);
        liquidacion.setId_Inst_Salud(salud);
        objLiquidacionService.actualizacionLiquidacion(liquidacion, id_liquidacion);
        return "redirect:/liquidacion";
    }



    @PostMapping("/eliminar/{id_liquidacion}")
    public String eliminarLiquidacion(@PathVariable int id_liquidacion){
        objLiquidacionService.eliminarLiquicadion(id_liquidacion);
        return "redirect:/liquidacion";
    }
}
