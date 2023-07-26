package cl.sprint.Sprint.service.serviceImpl;


import cl.sprint.Sprint.entity.InstitucionPrevision;
import cl.sprint.Sprint.repository.IPrevisionRepository;
import cl.sprint.Sprint.service.IPrevicionSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("previsionImpl")
public class InstiPrevisionImpl implements IPrevicionSerive {
    @Autowired
    IPrevisionRepository objPrevisionRepo;
    @Override
    public List<InstitucionPrevision> listarPrevision() {
        return objPrevisionRepo.findAll();
    }

    @Override
    public InstitucionPrevision buscarPrevisionPorId(int id_inst_prevision) {
        return objPrevisionRepo.findById(id_inst_prevision).orElseThrow(() -> new NoSuchElementException("Institución no encontrada"));
    }
}
