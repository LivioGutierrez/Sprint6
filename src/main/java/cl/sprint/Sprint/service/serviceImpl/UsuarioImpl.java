package cl.sprint.Sprint.service.serviceImpl;

import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.repository.IUsuarioRepository;
import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public List<Usuario> listarUsuario() {
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {

        return objUsuarioRepo.save(usuario);
    }

    //Registrar usuario
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorID(int id_usuario) {
        return objUsuarioRepo.findById(id_usuario).orElseThrow(()-> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar, int id_usuario) {
        Usuario usuario = objUsuarioRepo.findById(usuarioActualizar.getId_usuario()).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setApellido1(usuarioActualizar.getApellido1());
        usuario.setApellido2(usuarioActualizar.getApellido2());
        usuario.setPerfil(usuarioActualizar.getPerfil());
        usuario.setEmail(usuarioActualizar.getEmail());
        //usuario.setFecha_creacion(usuarioActualizar.getFecha_creacion());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id_usuario) {
        objUsuarioRepo.deleteById(id_usuario);
    }
}
