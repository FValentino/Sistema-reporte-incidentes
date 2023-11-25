package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoMesaAyuda;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoMesaAyudaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpleadoMesaAyudaService {
    
    @Autowired
    private EmpleadoMesaAyudaRepository empleadoMesaAyudaRepo;
    
    //Crud basico
    public void agregarCliente(EmpleadoMesaAyuda empleado){
        empleadoMesaAyudaRepo.save(empleado);
    }
    
    public void eliminarCliente(int cuit){
        empleadoMesaAyudaRepo.deleteById(cuit);
    }
    
    public Optional<EmpleadoMesaAyuda> buscarCliente(int cuit){
        return empleadoMesaAyudaRepo.findById(cuit);
    }
    
    public List <EmpleadoMesaAyuda> mostrarTodos(){
        return empleadoMesaAyudaRepo.findAll();
    }
    
    public void modificarEmpleado(EmpleadoMesaAyuda empleado){
        
        empleadoMesaAyudaRepo.save(empleado);
    }
}
