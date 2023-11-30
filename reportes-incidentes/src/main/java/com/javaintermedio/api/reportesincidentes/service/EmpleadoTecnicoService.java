package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.EmpleadoTecnico;
import com.javaintermedio.api.reportesincidentes.model.Usuario;
import com.javaintermedio.api.reportesincidentes.repository.EmpleadoTecnicoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpleadoTecnicoService {
    
    @Autowired
    private EmpleadoTecnicoRepository empleadoTecnicoRepo;
    
    @Autowired
    private UsuarioService usuarioService;
    
    //Crud basico
    public void agregarEmpleadoTecnico(EmpleadoTecnico empleado){
        String password = empleado.getNombre() + "-" + empleado.getDni();
        
        this.empleadoTecnicoRepo.save(empleado);
        this.usuarioService.cargarUsuario(new Usuario (empleado.getIdEmpleadoComercial(), empleado.getEmail(), password));
    }
    
    public void eliminarEmpleadoTecnico(long id){
        this.empleadoTecnicoRepo.deleteById(id);
    }
    
    public Optional<EmpleadoTecnico> buscarEmpleadoTecnico(long id){
        return this.empleadoTecnicoRepo.findById(id);
    }
    
    public List <EmpleadoTecnico> mostrarTodos(){
        return this.empleadoTecnicoRepo.findAll();
    }
    
    public void modificarEmpleadoTecnico(long id, EmpleadoTecnico empleado){
        
        EmpleadoTecnico empleadoAux = this.empleadoTecnicoRepo.findById(id).orElse(empleado);
        
        empleadoAux.setDni(empleado.getDni());
        empleadoAux.setNombre(empleado.getNombre());
        empleadoAux.setEmail(empleado.getEmail());
        empleadoAux.setTelefono(empleado.getTelefono());
        
        this.empleadoTecnicoRepo.save(empleado);
    }
}
