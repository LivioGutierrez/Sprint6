package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name ="empleador")
public class Empleador {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empleador;

    @Column(unique = true, nullable = false)
    private int run;

    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(length = 100,nullable = false)
    private String apellido1;

    @Column(length = 100)
    private String apellido2;

    @Column(length = 500)
    private String direccion;

    @Column(length = 100)
    private String email;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column
    private long telefono;

    @ManyToMany
    @JoinTable(name = "empl_trab",//con que tabla que se relacionara
    joinColumns = @JoinColumn(name = "id_empleador", nullable = false),//la tabla de la relacion
    inverseJoinColumns = @JoinColumn(name = "id_trabajor",nullable = false))//hacia donde sige la relacion
    private List<Trabajador>trabajadores;
}
