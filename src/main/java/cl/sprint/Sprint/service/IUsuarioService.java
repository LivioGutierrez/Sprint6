package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario>listarUsuario();
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorID(int id_usuario);
    Usuario actualizarUsuario(Usuario usuario, int id_usuario);
    public void  eliminarUsuario(int id_usuario);

}
