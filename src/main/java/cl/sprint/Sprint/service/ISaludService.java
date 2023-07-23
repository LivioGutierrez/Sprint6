package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.InstitucionSalud;

import java.util.List;

public interface ISaludService{
    List<InstitucionSalud> listarSalud();
    InstitucionSalud buscarSaludPorId(int idInstSalud);
}
