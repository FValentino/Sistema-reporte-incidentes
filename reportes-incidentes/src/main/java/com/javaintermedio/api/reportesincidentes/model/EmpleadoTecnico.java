package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="tecnico")
public class EmpleadoTecnico extends Empleado{
    
    @Column(name="especialidad")
    private String especialidad;

   
    public EmpleadoTecnico(int dni, String nombre, String email, String telefono, String especialidad) {
        super(dni, nombre, email, telefono);
        this.especialidad = especialidad;
    }
    
}
