package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes-incidentes")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    //Crud basico
    
    //Acceso del usuario
    @GetMapping(value = "/usuarios")
    public List <Usuario> mostrarTodos(){
        return this.usuarioService.mostrarTodos();
    }
    
    @GetMapping(value = "/usuario/{id}")
    public Usuario buscarUsuario(@PathVariable long id){
        return this.usuarioService.buscarUsuario(id).orElse(null);
    }
    
    @DeleteMapping(value = "usuario/eliminar/{id}")
    public void eliminarUsuario(@PathVariable long id){
        this.usuarioService.eliminarUsuario(id);
    }
    
    @PutMapping(value = "/usuario/actualizar/{id}")
    public void modificarPassword(long id, String password){
        this.usuarioService.modificarPassword(id, password);
    }
    
    //Se realizan de forma automatica
    public void cargarUsuario(Usuario usuario){
        //El campo password se rellena por defecto con "nombbre del empleado - dni del empleado"
        this.usuarioService.cargarUsuario(usuario);
    }
    
    
    public Usuario findByEmail(String email){
        return this.usuarioService.findByEmail(email);
    }
}
