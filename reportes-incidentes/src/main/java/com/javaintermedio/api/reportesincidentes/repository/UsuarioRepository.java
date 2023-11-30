package com.javaintermedio.api.reportesincidentes.repository;

import com.javaintermedio.api.reportesincidentes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    
    public Usuario findByEmail(String email);
}
