package cl.sprint.Sprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="institucion_salud")
public class InstitucionSalud {
    private int id_inst_salud;
    private String descripcion;
    private float porc_dcto;
}
