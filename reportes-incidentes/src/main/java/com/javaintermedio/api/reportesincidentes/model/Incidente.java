package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.*;
import java.time.format.DateTimeFormatter;
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
    @Column(name = "id_tecnico", nullable = false)
    private long idTecnico;
    @Column(name = "fecha_registro", nullable=false, updatable=false)
    @Temporal(TemporalType.DATE)
    private String fechaRegistro = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    @Column(name = "fecha_estimada_solucion", nullable = false, length = 10)
    @Temporal (TemporalType.DATE)
    private String fechaEstimadaSolucion;
    @Column (name = "fecha_solucion", length = 10)
    @Temporal (TemporalType.DATE)
    private String fechaSolucion = null;

    
    public Incidente(long idIncidente, String tipoProblema, String descripcionProblema, long idTecnico, String fechaEstimadaSolucion) {
        this.idIncidente = idIncidente;
        this.tipoProblema = tipoProblema;
        this.descripcionProblema = descripcionProblema;
        this.idTecnico = idTecnico;
        //En caso de que la fecha ingresada no sea valida, se ocupara un valor predeterminado de una semana
        //Es decir la fecha de solucion estimada sera una semana despues de haber registrado el incidente
        try{
            this.fechaEstimadaSolucion=fechaEstimadaSolucion;   
        }catch(Exception e){
            this.fechaEstimadaSolucion=LocalDate.now().plusDays(7L).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
    }
    
    public Incidente(String tipoProblema, String descripcionProblema, long idTecnico, String fechaEstimadaSolucion) {
        this.tipoProblema = tipoProblema;
        this.descripcionProblema = descripcionProblema;
        this.idTecnico = idTecnico;
        //En caso de que la fecha ingresada no sea valida, se ocupara un valor predeterminado de una semana
        //Es decir la fecha de solucion estimada sera una semana despues de haber registrado el incidente
        try{
            this.fechaEstimadaSolucion=fechaEstimadaSolucion;   
        }catch(Exception e){
            this.fechaEstimadaSolucion=LocalDate.now().plusDays(7L).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
    }

    public Incidente() {
    }

    
    
    
}
