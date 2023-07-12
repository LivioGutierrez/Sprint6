package cl.sprint.Sprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name ="liquidacion")
public class Liquidacion {
    private int id_liquidacion;
    private int id_trabajador;
    private LocalDate periodo;
    private int sueldo_imponible;
    private int sueldo_liquido;
    private int id_inst_salud;
    private int monto_inst_salud;
    private int id_inst_previsional;
    private int total_descuento;
    private int total_haberes;
    private int anticipado;
}
