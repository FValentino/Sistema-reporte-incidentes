package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    //Crud basico
    public List <Usuario> mostrarTodos(){
        return this.usuarioRepo.findAll();
    }
    
    public void cargarUsuario(Usuario usuario){
        this.usuarioRepo.save(usuario);
    }
    
    public Usuario findByEmail(String email){
        return this.usuarioRepo.findByEmail(email);
    }
    
    public void eliminarUsuario(long id){
        this.usuarioRepo.deleteById(id);
    }
    
    public void modificarEmail(long id, String email){
        Usuario usuarioAux = this.usuarioRepo.findById(id).orElse(null);
        
        usuarioAux.setEmail(email);
        
        this.usuarioRepo.save(usuarioAux);
    }
    
    public void modificarPassword(long id, String password){
        Usuario usuarioAux = this.usuarioRepo.findById(id).orElse(null);
        
        usuarioAux.setPassword(password);
        
        this.usuarioRepo.save(usuarioAux);
    }
}
