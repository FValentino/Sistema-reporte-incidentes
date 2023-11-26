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
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente", nullable=false)
    private long idCliente;
    @Column(name = "cuit", nullable=false, length = 12)
    private long cuit;
    @Column(name = "razon_social", nullable=false, length = 70 )
    private String razonSocial;
    @Column(name = "telefono", nullable=false, length = 10 )
    private String telefono;
    @Column(name = "direccion", nullable=false, length = 70)
    private String direccion;

    public Cliente(long idCliente, int cuit, String razonSocial, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
    }
}
