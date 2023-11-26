package com.javaintermedio.api.reportesincidentes.repository;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoRecursosHumanos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRecursosHumanosRepository extends JpaRepository<EmpleadoRecursosHumanos, Long>{
    
}
