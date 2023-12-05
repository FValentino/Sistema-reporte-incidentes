package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoRecursosHumanos;
import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoRecursosHumanosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpleadoRecursosHumanosService {
    
    @Autowired
    private EmpleadoRecursosHumanosRepository empleadoRecursosHumanosRepo;
    
    @Autowired
    private UsuarioService usuarioService;
    
    //Crud basico
    public void agregarEmpleadoRecursosHumanos(EmpleadoRecursosHumanos empleado){
        String password = empleado.getNombre() + "-" + empleado.getDni();
        
        this.empleadoRecursosHumanosRepo.save(empleado);
        this.usuarioService.cargarUsuario(new Usuario (empleado.getIdEmpleado(), empleado.getEmail(), password));
    }
    
    public void eliminarEmpleadoRecursosHumanos(long id){
        this.empleadoRecursosHumanosRepo.deleteById(id);
    }
    
    public Optional<EmpleadoRecursosHumanos> buscarEmpleadoRecursosHumanos(long id){
        return this.empleadoRecursosHumanosRepo.findById(id);
    }
    
    public List <EmpleadoRecursosHumanos> mostrarTodos(){
        return this.empleadoRecursosHumanosRepo.findAll();
    }
    
    public void modificarEmpleadoRecursosHumanos(long id, EmpleadoRecursosHumanos empleado){
        
        EmpleadoRecursosHumanos empleadoAux = this.empleadoRecursosHumanosRepo.findById(id).orElse(empleado);
        
        if ( !empleado.getEmail().equals(empleadoAux.getEmail()) ){
            this.usuarioService.modificarEmail(empleado.getIdEmpleado(), empleado.getEmail());
        }
        
        empleadoAux.setDni(empleado.getDni());
        empleadoAux.setNombre(empleado.getNombre());
        empleadoAux.setEmail(empleado.getEmail());
        empleadoAux.setTelefono(empleado.getTelefono());
        
        this.empleadoRecursosHumanosRepo.save(empleado);
    }
}
