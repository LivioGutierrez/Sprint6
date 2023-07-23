package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.InstitucionPrevision;

import java.util.List;

public interface IPrevicionSerive {
    List<InstitucionPrevision> listarPrevision();
    InstitucionPrevision buscarPrevisionPorId(int idInstPrevision);
}
