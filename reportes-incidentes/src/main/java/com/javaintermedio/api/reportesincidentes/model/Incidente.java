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
    @Column(name="id_cliente", nullable = false)
    private long idCliente;
    @Column(name = "id_servicio", nullable = false, length = 50)
    private long idServicio;
    @Column(name = "descripcion_problema", nullable = false, length = 150)
    private String descripcionProblema;
    @Column(name = "id_tecnico", nullable = false)
    private long idTecnico;
    @Column(name = "fecha_registro", nullable=false, updatable=false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaRegistro = LocalDate.now();
    @Column(name = "fecha_estimada_solucion", nullable = false, length = 10)
    @Temporal (TemporalType.DATE)
    private LocalDate fechaEstimadaSolucion;
    @Column (name = "fecha_solucion", length = 10)
    @Temporal (TemporalType.DATE)
    private String fechaSolucion = null;
    
    public Incidente(long idCliente, long idServicio, String descripcionProblema, long idTecnico, String fechaEstimadaSolucion) {
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.descripcionProblema = descripcionProblema;
        this.idTecnico = idTecnico;
        //En caso de que la fecha ingresada no sea valida, se ocupara un valor predeterminado de una semana
        //Es decir la fecha de solucion estimada sera una semana despues de haber registrado el incidente
        try{
            //Si la fecha estimada de solucion es mayor a la fecha delr egistro, es aceptada
            if ( this.fechaRegistro.compareTo(LocalDate.parse(fechaEstimadaSolucion)) <= 0){
                this.fechaEstimadaSolucion = LocalDate.parse(fechaEstimadaSolucion);
            } else{ //Si la fecha es menor, se toma como fecha de solucion 7 dias despues
                this.fechaEstimadaSolucion = this.fechaRegistro.plusDays(7L);
            }  
        }catch(Exception e){
            this.fechaEstimadaSolucion=this.fechaRegistro.plusDays(7L);
        }
    }

    public Incidente() {
    }

    
    
    
}
