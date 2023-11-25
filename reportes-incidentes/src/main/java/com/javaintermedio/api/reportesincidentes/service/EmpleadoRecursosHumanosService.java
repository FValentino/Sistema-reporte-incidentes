package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoRecursosHumanos;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoRecursosHumanosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoRecursosHumanosService {
    
    @Autowired
    private EmpleadoRecursosHumanosRepository empleadoRecursosHumanosRepo;
    
    //Crud basico
    public void agregarCliente(EmpleadoRecursosHumanos empleado){
        empleadoRecursosHumanosRepo.save(empleado);
    }
    
    public void eliminarCliente(int cuit){
        empleadoRecursosHumanosRepo.deleteById(cuit);
    }
    
    public Optional<EmpleadoRecursosHumanos> buscarCliente(int cuit){
        return empleadoRecursosHumanosRepo.findById(cuit);
    }
    
    public List <EmpleadoRecursosHumanos> mostrarTodos(){
        return empleadoRecursosHumanosRepo.findAll();
    }
    
    public void modificarEmpleado(EmpleadoRecursosHumanos empleado){
        
        empleadoRecursosHumanosRepo.save(empleado);
    }
}
