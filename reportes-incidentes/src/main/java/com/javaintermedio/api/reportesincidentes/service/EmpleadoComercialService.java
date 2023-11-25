package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoComercial;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoComercialRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoComercialService {
    
    @Autowired
    private EmpleadoComercialRepository empleadoComercialRepo;
    
    //Crud basico
    public void agregarCliente(EmpleadoComercial empleado){
        empleadoComercialRepo.save(empleado);
    }
    
    public void eliminarCliente(int cuit){
        empleadoComercialRepo.deleteById(cuit);
    }
    
    public Optional<EmpleadoComercial> buscarCliente(int cuit){
        return empleadoComercialRepo.findById(cuit);
    }
    
    public List <EmpleadoComercial> mostrarTodos(){
        return empleadoComercialRepo.findAll();
    }
    
    public void modificarEmpleado(EmpleadoComercial empleado){
        
        empleadoComercialRepo.save(empleado);
    }
}
