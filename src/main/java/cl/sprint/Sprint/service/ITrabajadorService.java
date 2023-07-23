package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    List<Trabajador> listarTrabajador();

    Trabajador crearTrabajador(Trabajador trabajador);

    Trabajador buscarTrabajadorPorID(int id_trabajador);
    Trabajador actualizarTrabajador(Trabajador trabajador,int id_trabajador);
    public void eliminar(int id_trabajador);
}
