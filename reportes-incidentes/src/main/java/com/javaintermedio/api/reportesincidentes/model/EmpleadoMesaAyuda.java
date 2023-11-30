package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="mesa de ayuda")
public class EmpleadoMesaAyuda extends Empleado{

    public EmpleadoMesaAyuda(int dni, String nombre, String email, String telefono) {
        super(dni, nombre, email, telefono);
    }
    
}
