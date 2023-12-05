package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.IncidenteResuelto;
import com.javaintermedio.api.reportesincidentes.repository.IncidenteRepository;
import java.util.List;
import java.util.Optional;
import com.javaintermedio.api.reportesincidentes.repository.IncidenteResueltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class IncidentesResueltosService {
    
    @Autowired
    private IncidenteResueltoRepository incidenteResueltoRepo;
    
    @Autowired
    private IncidenteService incidenteService;
    
    //Crud basico
    public void agregarIncidente(IncidenteResuelto incidente){
        incidenteResueltoRepo.save(incidente);
        this.incidenteService.eliminarIncidente(incidente.getIdIncidente());
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
