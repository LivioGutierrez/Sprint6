package cl.sprint.Sprint.service.serviceImpl;
import cl.sprint.Sprint.entity.Trabajador;
import cl.sprint.Sprint.repository.ITrabajadorRepository;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("trabajadorImpl")
public class TrabajadorImpl implements ITrabajadorService {
    @Autowired
    ITrabajadorRepository objTrabajadorRepo;

    @Override
    public List<Trabajador> listarTrabajador() {
        return objTrabajadorRepo.findAll();
    }

    @Override
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public Trabajador buscarTrabajadorPorID(int id_trabajador) {
        return objTrabajadorRepo.findById(id_trabajador).orElseThrow(()->new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajadorActualizar, int id_trabajador) {
        Trabajador trabajador = objTrabajadorRepo.findById(id_trabajador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
        trabajador.setRun(trabajadorActualizar.getRun());
        trabajador.setNombre(trabajadorActualizar.getNombre());
        trabajador.setApellido1(trabajadorActualizar.getApellido1());
        trabajador.setApellido2(trabajadorActualizar.getApellido2());
        trabajador.setEmail(trabajadorActualizar.getEmail());
        trabajador.setId_inst_prevision(trabajadorActualizar.getId_inst_prevision());
        trabajador.setId_inst_salud(trabajadorActualizar.getId_inst_salud());
        trabajador.setTelefono(trabajadorActualizar.getTelefono());
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public void eliminar(int id_trabajador) {
        objTrabajadorRepo.deleteById(id_trabajador);
    }
}
