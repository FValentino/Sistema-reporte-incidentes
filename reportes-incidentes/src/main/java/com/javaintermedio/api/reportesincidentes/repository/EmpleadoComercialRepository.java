package com.javaintermedio.api.reportesincidentes.repository;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoComercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoComercialRepository extends JpaRepository<EmpleadoComercial, Long>{
    
}
