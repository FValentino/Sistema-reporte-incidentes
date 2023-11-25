package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente", nullable = false)
    private long idIncidente;
    @Column(name = "tipo_problema", nullable = false, length = 50)
    private String tipoProblema;
    @Column(name = "descripcion_problema", nullable = false, length = 150)
    private String descripcionProblema;
    @Column(name = "fecha_contratacion", nullable = false, length = 12)
    private LocalDate fechaContratacion;

    public Servicio(long idIncidente, String tipoProblema, String descripcionProblema, LocalDate fechaContratacion) {
        this.idIncidente = idIncidente;
        this.tipoProblema = tipoProblema;
        this.descripcionProblema = descripcionProblema;
        this.fechaContratacion = fechaContratacion;
    }

    public Servicio() {
    }
    
    
}
