package cl.sprint.Sprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="perfl")
public class Perfil {
    private int id_perfil;
    private String descripcion;
    private boolean estado;
}
