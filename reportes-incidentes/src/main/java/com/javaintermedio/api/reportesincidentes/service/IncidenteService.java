package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.Incidente;
import com.javaintermedio.api.reportesincidentes.repository.IncidenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class IncidenteService {
    
    @Autowired
    private IncidenteRepository incidenteRepo;
    
    //Crud basico
    public void agregarIncidente(Incidente incidente){
        incidenteRepo.save(incidente);
    }
    
    public void eliminarIncidente(long id){
        incidenteRepo.deleteById(id);
    }
    
    public Optional<Incidente> buscarIncidente(long id){
        return incidenteRepo.findById(id);
    }
    
    public List <Incidente> mostrarTodos(){
        return incidenteRepo.findAll();
    }
    
    public void modificarIncidente(Incidente incidente){
        
        incidenteRepo.save(incidente);
    }
}
