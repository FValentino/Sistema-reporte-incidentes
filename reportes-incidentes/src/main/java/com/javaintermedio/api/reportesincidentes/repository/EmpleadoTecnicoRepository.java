package com.javaintermedio.api.reportesincidentes.repository;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoTecnicoRepository extends JpaRepository<EmpleadoTecnico, Long>{
    
}
