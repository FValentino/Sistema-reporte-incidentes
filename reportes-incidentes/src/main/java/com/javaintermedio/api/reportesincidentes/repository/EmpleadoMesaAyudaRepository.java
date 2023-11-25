package com.javaintermedio.api.reportesincidentes.repository;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoMesaAyuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoMesaAyudaRepository extends JpaRepository<EmpleadoMesaAyuda, Integer> {
    
}
