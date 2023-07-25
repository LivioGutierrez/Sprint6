package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.Liquidacion;

import java.util.List;

public interface ILiquidicionService {
    List<Liquidacion> listarLiquidaciones();
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    Liquidacion buscarLiquidacion(long id_liquidacion);
    Liquidacion actualizacionLiquidacion(Liquidacion liquidacion, long id_liquidacion);
    public void eliminarLiquicadion(long id_liquidacion);
}
