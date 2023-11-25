package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoTecnico;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoTecnicoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoTecnicoService {
    
    @Autowired
    private EmpleadoTecnicoRepository empleadoTecnicoRepo;
    
    //Crud basico
    public void agregarCliente(EmpleadoTecnico empleado){
        empleadoTecnicoRepo.save(empleado);
    }
    
    public void eliminarCliente(int cuit){
        empleadoTecnicoRepo.deleteById(cuit);
    }
    
    public Optional<EmpleadoTecnico> buscarCliente(int cuit){
        return empleadoTecnicoRepo.findById(cuit);
    }
    
    public List <EmpleadoTecnico> mostrarTodos(){
        return empleadoTecnicoRepo.findAll();
    }
    
    public void modificarEmpleado(EmpleadoTecnico empleado){
        
        empleadoTecnicoRepo.save(empleado);
    }
}
