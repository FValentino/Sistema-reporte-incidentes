package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="comercial")
public class EmpleadoComercial extends Empleado{
    
    public EmpleadoComercial(int dni, String nombre, String email, String telefono) {
        super(dni, nombre, email, telefono);
    }
    
}
