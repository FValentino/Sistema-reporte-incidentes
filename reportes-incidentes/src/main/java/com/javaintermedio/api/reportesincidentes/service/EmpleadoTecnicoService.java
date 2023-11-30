package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoTecnico;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoTecnicoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpleadoTecnicoService {
    
    @Autowired
    private EmpleadoTecnicoRepository empleadoTecnicoRepo;
    
    //Crud basico
    public void agregarEmpleadoTecnico(EmpleadoTecnico empleado){
        empleadoTecnicoRepo.save(empleado);
    }
    
    public void eliminarEmpleadoTecnico(long id){
        empleadoTecnicoRepo.deleteById(id);
    }
    
    public Optional<EmpleadoTecnico> buscarEmpleadoTecnico(long id){
        return empleadoTecnicoRepo.findById(id);
    }
    
    public List <EmpleadoTecnico> mostrarTodos(){
        return empleadoTecnicoRepo.findAll();
    }
    
    public void modificarEmpleadoTecnico(long id, EmpleadoTecnico empleado){
        
        EmpleadoTecnico empleadoAux = this.empleadoTecnicoRepo.findById(id).orElse(empleado);
        
        empleadoAux.setDni(empleado.getDni());
        empleadoAux.setNombre(empleado.getNombre());
        empleadoAux.setEmail(empleado.getEmail());
        empleadoAux.setTelefono(empleado.getTelefono());
        
        empleadoTecnicoRepo.save(empleado);
    }
}
