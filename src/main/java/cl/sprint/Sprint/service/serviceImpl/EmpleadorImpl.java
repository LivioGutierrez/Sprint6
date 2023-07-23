package cl.sprint.Sprint.service.serviceImpl;

import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.repository.IEmpleadorRepository;
import cl.sprint.Sprint.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {
    @Autowired
    IEmpleadorRepository objEmpleadorRepo;
    @Override
    public List<Empleador> listarEmpleador() {

        return objEmpleadorRepo.findAll();
    }

    @Override
    public Empleador crearEmpleador(Empleador empleador) {

        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public Empleador buscarEmpleadorPorID(int id_empleador) {
        return objEmpleadorRepo.findById(id_empleador).orElseThrow(()-> new NoSuchElementException("Empleador no encontrado"));
    }

    @Override
    public Empleador actualizarEmpleador(Empleador empleadorActualizar, int id_empleador) {
        Empleador empleador = objEmpleadorRepo.findById(id_empleador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
        empleador.setRun(empleadorActualizar.getRun());
        empleador.setNombre(empleadorActualizar.getNombre());
        empleador.setApellido1(empleadorActualizar.getApellido1());
        empleador.setApellido2(empleadorActualizar.getApellido2());
        empleador.setDireccion(empleadorActualizar.getDireccion());
        empleador.setEmail(empleadorActualizar.getEmail());
        empleador.setUsuario(empleadorActualizar.getUsuario());
        empleador.setTelefono(empleadorActualizar.getTelefono());
        empleador.setTrabajadores(empleadorActualizar.getTrabajadores());
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public void eliminar(int id_empleador) {

        objEmpleadorRepo.deleteById(id_empleador);
    }
}
