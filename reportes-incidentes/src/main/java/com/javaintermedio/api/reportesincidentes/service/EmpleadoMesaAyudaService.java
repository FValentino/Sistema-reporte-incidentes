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
    public void agregarEmpleadoMesaAyuda(EmpleadoMesaAyuda empleado){
        empleadoMesaAyudaRepo.save(empleado);
    }
    
    public void eliminarEmpleadoMesaAyuda(long id){
        empleadoMesaAyudaRepo.deleteById(id);
    }
    
    public Optional<EmpleadoMesaAyuda> buscarEmpleadoMesaAyuda(long id){
        return empleadoMesaAyudaRepo.findById(id);
    }
    
    public List <EmpleadoMesaAyuda> mostrarTodos(){
        return empleadoMesaAyudaRepo.findAll();
    }
    
    public void modificarEmpleadoMesaAyuda(long id, EmpleadoMesaAyuda empleado){
        EmpleadoMesaAyuda empleadoAux = this.empleadoMesaAyudaRepo.findById(id).orElse(empleado);
        
        empleadoAux.setDni(empleado.getDni());
        empleadoAux.setNombre(empleado.getNombre());
        empleadoAux.setEmail(empleado.getEmail());
        empleadoAux.setTelefono(empleado.getTelefono());
        
        empleadoMesaAyudaRepo.save(empleado);
    }
}
