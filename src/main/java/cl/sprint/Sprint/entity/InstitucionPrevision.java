package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name ="institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(nullable = false)
    private int id_inst_prevision;

    @Column(length = 50,nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private float porc_dcto;

    @OneToMany(mappedBy = "id_inst_prevision")
    List<Trabajador>listarTrabajadores;

    @OneToMany(mappedBy = "id_Inst_previsional")
    List<Liquidacion> liquidacionesPrevision;
}
