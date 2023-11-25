package com.javaintermedio.api.reportesincidentes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {
    
    @Id
    @Column(name = "cuit", nullable=false, length = 11)
    private int cuit;
    @Column(name = "razon_social", nullable=false, length = 70 )
    private String razonSocial;
    private String telefono;
    @Column(name = "direccion", nullable=false, length = 70)
    private String direccion;

    public Cliente(int cuit, String razonSocial, String telefono, String direccion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
    }
    
}
