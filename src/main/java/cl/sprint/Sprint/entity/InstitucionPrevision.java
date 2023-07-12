package cl.sprint.Sprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="institucion_prevencion")
public class InstitucionPrevision {
    private int id_inst_prevision;
    private String descripcion;
    private float porc_dcto;
}
