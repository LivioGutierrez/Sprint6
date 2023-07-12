package cl.sprint.Sprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="trabajador")
public class Trabajador {
    private int id_trabajo;
    private int run;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private int inst_prevision;//ID
    private int getInst_salud;//ID
    private int telefono;
}
