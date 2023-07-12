package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name ="trabajador")
public class Trabajador {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_trabajo;

    @Column(unique = true, nullable = false)
    private int run;

    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(length = 100,nullable = false)
    private String apellido1;

    @Column(length = 100)
    private String apellido2;

    @Column(length = 100)
    private String email;

    @ManyToOne(optional = false,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision", nullable = false)
    private InstitucionPrevision id_inst_prevision;//ID

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud id_inst_salud;//ID

    @Column
    private int telefono;
    @ManyToMany(mappedBy = "trabajadores")
    private List<Empleador>empleadores;
}
