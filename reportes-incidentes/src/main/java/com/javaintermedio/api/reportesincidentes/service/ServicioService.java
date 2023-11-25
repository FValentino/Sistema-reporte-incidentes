package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.Servicio;
import com.javaintermedio.api.reportesincidentes.repository.ServicioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ServicioService {
    
    @Autowired
    private ServicioRepository servicioRepo;
    
    //Crud basico
    public void agregarServicio(Servicio servicio){
        servicioRepo.save(servicio);
    }
    
    public void eliminarServicio(long id){
        servicioRepo.deleteById(id);
    }
    
    public Optional<Servicio> buscarIncidente(long id){
        return servicioRepo.findById(id);
    }
    
    public List <Servicio> mostrarTodos(){
        return servicioRepo.findAll();
    }
    
    public void modificarIncidente(Servicio servicio){
        
        servicioRepo.save(servicio);
    }
}
