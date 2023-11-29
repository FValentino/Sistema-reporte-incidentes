package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class IncidenteResuelto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente", nullable = false)
    private long idIncidente;
    @Column(name = "tipo_problema", nullable = false, length = 50)
    private String tipoProblema;
    @Column(name = "descripcion_problema", nullable = false, length = 150)
    private String descripcionProblema;
    @Column(name = "id_tecnico", nullable = false)
    private long idTecnico;
    @Column(name = "fecha_registro", updatable=false ,nullable = false, length = 10)
    @Temporal(TemporalType.DATE)
    private String fechaRegistro;
    @Column(name = "fecha_estimada_solucion", nullable = false, length = 10)
    @Temporal (TemporalType.DATE)
    private String fechaEstimadaSolucion;
    @Column (name = "fecha_solucion", length = 10)
    @Temporal (TemporalType.DATE)
    private String fechaSolucion;

    public IncidenteResuelto (long idIncidente, String tipoProblema, String descripcionProblema, long idTecnico, String fechaSolucion) {
        this.idIncidente = idIncidente;
        this.tipoProblema = tipoProblema;
        this.descripcionProblema = descripcionProblema;
        this.idTecnico = idTecnico;
        //En caso de que la fecha ingresada no sea valida, se ocupara un valor predeterminado de una semana
        //Es decir la fecha de solucion estimada sera una semana despues de haber registrado el incidente
        try{
            this.fechaSolucion=fechaSolucion;   
        }catch(Exception e){
            this.fechaSolucion = null;
        }
    }

    public IncidenteResuelto () {
    }
    
}
