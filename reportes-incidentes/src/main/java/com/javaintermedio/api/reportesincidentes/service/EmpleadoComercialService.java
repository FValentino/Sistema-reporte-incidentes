package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoComercial;
import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoComercialRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpleadoComercialService {
    
    @Autowired
    private EmpleadoComercialRepository empleadoComercialRepo;
    
    @Autowired
    private UsuarioService usuarioService;
    
    //Crud basico
    public void agregarEmpleadoComercial(EmpleadoComercial empleado){
        String password = empleado.getNombre() + "-" + empleado.getDni();
        
        this.empleadoComercialRepo.save(empleado);
        
        this.usuarioService.cargarUsuario(new Usuario (empleado.getIdEmpleadoComercial(), empleado.getEmail(), password));
    }
    
    public void eliminarEmpleadoComercial(long id){
        empleadoComercialRepo.deleteById(id);
    }
    
    public Optional<EmpleadoComercial> buscarEmpleadoComercialById(long id){
        return empleadoComercialRepo.findById(id);
    }
    
    
    public List <EmpleadoComercial> mostrarTodos(){
        return empleadoComercialRepo.findAll();
    }
    
    public void modificarEmpleadoComercial(long id, EmpleadoComercial empleado){
        
        EmpleadoComercial empleadoAux = this.empleadoComercialRepo.findById(id).orElse(empleado);
        
        if ( !empleado.getEmail().equals(empleadoAux.getEmail()) ){
            this.usuarioService.modificarEmail(empleado.getIdEmpleadoComercial(), empleado.getEmail());
        }
        
        empleadoAux.setDni(empleado.getDni());
        empleadoAux.setNombre(empleado.getNombre());
        empleadoAux.setEmail(empleado.getEmail());
        empleadoAux.setTelefono(empleado.getTelefono());
        
        this.empleadoComercialRepo.save(empleado);
    }
}
