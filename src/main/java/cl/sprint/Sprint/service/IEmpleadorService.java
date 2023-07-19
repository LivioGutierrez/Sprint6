package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.entity.Usuario;

import java.util.List;

public interface IEmpleadorService {
    List<Empleador>listarEmpleador();

    Empleador crearEmpleador(Empleador empleador);

    Empleador buscarEmpleadorPorID(int id_empleador);
    Empleador actualizarEmpleador(Empleador empleador,int id_empleador);
    public void eliminar(int id_empleador);

}
