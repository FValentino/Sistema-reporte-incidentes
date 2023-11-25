package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Incidente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente", nullable = false)
    private long idIncidente;
    @Column(name = "tipo_problema", nullable = false, length = 50)
    private String tipoProblema;
    @Column(name = "descripcion_problema", nullable = false, length = 150)
    private String descripcionProblema;
    @Column(name = "fecha_registro", nullable = false, length = 12)
    private LocalDate fechaRegistro;
    @Column(name = "fecha_solucion", nullable = false, length = 12)
    private LocalDate fechaSolucion;
    @Column(name = "estado", nullable = false)
    private String estado;

    public Incidente(long idIncidente, String tipoProblema, String descripcionProblema, LocalDate fechaRegistro, LocalDate fechaSolucion, String estado) {
        this.idIncidente = idIncidente;
        this.tipoProblema = tipoProblema;
        this.descripcionProblema = descripcionProblema;
        this.fechaRegistro = fechaRegistro;
        this.fechaSolucion = fechaSolucion;
        this.estado = estado;
    }

    public Incidente() {
    }
    
    
}
