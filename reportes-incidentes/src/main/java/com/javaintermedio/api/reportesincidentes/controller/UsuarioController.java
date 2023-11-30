package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    //Crud basico
    public List <Usuario> mostrarTodos(){
        return this.usuarioService.mostrarTodos();
    }
    
    public void cargarUsuario(Usuario usuario){
        this.usuarioService.cargarUsuario(usuario);
    }
    
    public Usuario findByEmail(String email){
        return this.usuarioService.findByEmail(email);
    }
    
    public void modificarPassword(long id, String password){
        this.usuarioService.modificarPassword(id, password);
    }
}
