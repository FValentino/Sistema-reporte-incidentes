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
public class EmpleadoRecursosHumanos{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_empleado", nullable=false)
    private long idEmpleadoRecursosHumanos;
    @Column(name="dni", nullable=false, length = 8)
    private int dni;
    @Column(name="nombre", nullable=false, length = 50)
    private String nombre;
    @Column(name="email", nullable=false, length = 70)
    private String email;
    private String telefono;

    public EmpleadoRecursosHumanos(long idEmpleadoRecursosHumanos, int dni, String nombre, String email, String telefono) {
        this.idEmpleadoRecursosHumanos = idEmpleadoRecursosHumanos;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public EmpleadoRecursosHumanos() {
    }
    
    
}
