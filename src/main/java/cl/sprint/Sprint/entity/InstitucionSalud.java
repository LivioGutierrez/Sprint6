package cl.sprint.Sprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name ="institucion_salud")
public class InstitucionSalud {
    @Id
    @Column(nullable = false)
    private int id_inst_salud;

    @Column(length = 100,nullable = false)
    private String descripcion;

    @JsonIgnore
    @Column(nullable = false)
    private float porc_dcto;

    @JsonIgnore
    @OneToMany(mappedBy = "id_inst_salud")
    private List<Trabajador>listarTrabajadores;

    @JsonIgnore
    @OneToMany(mappedBy = "id_Inst_Salud")
    List<Liquidacion> liquidacionesSalud;
}
