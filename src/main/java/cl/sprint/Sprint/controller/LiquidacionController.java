package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Liquidacion;
import cl.sprint.Sprint.service.ILiquidicionService;
import cl.sprint.Sprint.service.IPrevicionSerive;
import cl.sprint.Sprint.service.ISaludService;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @PostMapping("/eliminar/{id_liquidacion}")
    public String eliminarLiquidacion(@PathVariable int id_liquidacion){
        objLiquidacionService.eliminarLiquicadion(id_liquidacion);
        return "redirect:/liquidacion";
    }
}
