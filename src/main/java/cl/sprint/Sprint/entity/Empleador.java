package cl.sprint.Sprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="empleador")
public class Empleador {
    private int id_empleador;
    private int run;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String email;
    private int id_usuario;
    private int telefono;
}
