package cl.sprint.Sprint.service.serviceImpl;

import cl.sprint.Sprint.entity.InstitucionPrevision;
import cl.sprint.Sprint.entity.InstitucionSalud;
import cl.sprint.Sprint.entity.Liquidacion;
import cl.sprint.Sprint.repository.ILiquidacionRepository;
import cl.sprint.Sprint.service.ILiquidicionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidicionService {
    @Autowired
    ILiquidacionRepository objLiquidacionRepo;
    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objLiquidacionRepo.findAll();
    }

    @Override
    @Transactional
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public Liquidacion buscarLiquidacion(long id_liquidacion) {
        return objLiquidacionRepo.findById(id_liquidacion).orElseThrow(() ->new NoSuchElementException("Liquidacion no encontrada"));
    }

    @Override
    public Liquidacion actualizacionLiquidacion(Liquidacion actualizarliquidacion, long id_liquidacion) {
        Liquidacion liquidacion = objLiquidacionRepo.findById(id_liquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
        liquidacion.setTrabajador(actualizarliquidacion.getTrabajador());
        liquidacion.setSueldo_imponible(actualizarliquidacion.getSueldo_imponible());
        liquidacion.setSueldo_liquido(actualizarliquidacion.getSueldo_imponible());
        liquidacion.setId_Inst_Salud(actualizarliquidacion.getId_Inst_Salud());
        liquidacion.setMonto_inst_salud(actualizarliquidacion.getMonto_inst_salud());
        liquidacion.setId_Inst_previsional(actualizarliquidacion.getId_Inst_previsional());
        liquidacion.setMonto_inst_previsional(actualizarliquidacion.getMonto_inst_previsional());
        liquidacion.setTotal_descuento(actualizarliquidacion.getTotal_descuento());
        liquidacion.setTotal_haberes(actualizarliquidacion.getTotal_haberes());
        liquidacion.setAnticipo(actualizarliquidacion.getAnticipo());
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public void eliminarLiquicadion(long id_liquidacion) {
        objLiquidacionRepo.deleteById(id_liquidacion);
    }
}
