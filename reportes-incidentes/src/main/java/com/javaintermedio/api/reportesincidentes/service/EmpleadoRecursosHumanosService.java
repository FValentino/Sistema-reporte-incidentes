package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoRecursosHumanos;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoRecursosHumanosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpleadoRecursosHumanosService {
    
    @Autowired
    private EmpleadoRecursosHumanosRepository empleadoRecursosHumanosRepo;
    
    //Crud basico
    public void agregarEmpleadoRecursosHumanos(EmpleadoRecursosHumanos empleado){
        empleadoRecursosHumanosRepo.save(empleado);
    }
    
    public void eliminarEmpleadoRecursosHumanos(long id){
        empleadoRecursosHumanosRepo.deleteById(id);
    }
    
    public Optional<EmpleadoRecursosHumanos> buscarEmpleadoRecursosHumanos(long id){
        return empleadoRecursosHumanosRepo.findById(id);
    }
    
    public List <EmpleadoRecursosHumanos> mostrarTodos(){
        return empleadoRecursosHumanosRepo.findAll();
    }
    
    public void modificarEmpleadoRecursosHumanos(long id, EmpleadoRecursosHumanos empleado){
        
        EmpleadoRecursosHumanos empleadoAux = this.empleadoRecursosHumanosRepo.findById(id).orElse(empleado);
        
        empleadoAux.setDni(empleado.getDni());
        empleadoAux.setNombre(empleado.getNombre());
        empleadoAux.setEmail(empleado.getEmail());
        empleadoAux.setTelefono(empleado.getTelefono());
        
        empleadoRecursosHumanosRepo.save(empleado);
    }
}
