package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="usuario")
public class Usuario {
    private int id_Usuario;
    private int run;
    private String nombre;
    private String apellido_1;
    private String apellido_2;
    private int id_perfil;
    private String email;
    private long telefono;
}
