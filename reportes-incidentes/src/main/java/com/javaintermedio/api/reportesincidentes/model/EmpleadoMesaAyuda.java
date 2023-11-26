package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmpleadoMesaAyuda{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_empleado", nullable=false)
    private long id;
    @Column(name="dni", nullable=false, length = 8)
    private int dni;
    @Column(name="nombre", nullable=false, length = 50)
    private String nombre;
    @Column(name="email", nullable=false, length = 70)
    private String email;
    private String telefono;

    public EmpleadoMesaAyuda(long id, int dni, String nombre, String email, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public EmpleadoMesaAyuda() {
    }
    
    
}
