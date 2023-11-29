package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.IncidenteResuelto;
import java.util.List;
import java.util.Optional;
import com.javaintermedio.api.reportesincidentes.repository.IncidenteResueltoRepository;
import org.springframework.stereotype.Service;

@Service
class IncidentesResueltosService {
    
    private IncidenteResueltoRepository incidenteResueltoRepo;
    
    //Crud basico
    public void agregarIncidente(IncidenteResuelto incidente){
        incidenteResueltoRepo.save(incidente);
    }
    
    public void eliminarIncidente(long id){
        incidenteResueltoRepo.deleteById(id);
    }
    
    public Optional<IncidenteResuelto> buscarIncidente(long id){
        return incidenteResueltoRepo.findById(id);
    }
    
    public List <IncidenteResuelto> mostrarTodos(){
        return incidenteResueltoRepo.findAll();
    }
    
}
