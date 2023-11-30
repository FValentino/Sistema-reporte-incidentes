package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="recursos humanos")
public class EmpleadoRecursosHumanos extends Empleado{

    public EmpleadoRecursosHumanos(int dni, String nombre, String email, String telefono) {
        super(dni, nombre, email, telefono);
    }
    
    
}
