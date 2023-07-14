package cl.sprint.Sprint.service.serviceImpl;

import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.repository.IUsuarioRepository;
import cl.sprint.Sprint.service.IUsuarioServie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class UsuarioImpl implements IUsuarioServie {

    @Autowired//
    IUsuarioRepository objUsuarioRepo;
    @Override
    public List<Usuario> listaUsuairo() {
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorID(int id_usuario) {
        return objUsuarioRepo.findById(id_usuario).orElseThrow(()-> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar) {
        Usuario usuario = objUsuarioRepo.findById(usuarioActualizar.getId_usuario()).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setApellido1(usuarioActualizar.getApellido1());
        usuario.setApellido2(usuarioActualizar.getApellido2());
        usuario.setPerfil(usuarioActualizar.getPerfil());
        usuario.setEmail(usuarioActualizar.getEmail());
        usuario.setFecha_creacion(usuarioActualizar.getFecha_creacion());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        return objUsuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }
}
