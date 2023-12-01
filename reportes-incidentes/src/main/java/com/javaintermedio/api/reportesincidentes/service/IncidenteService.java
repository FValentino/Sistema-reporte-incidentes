package com.javaintermedio.api.reportesincidentes.service;

import com.javaintermedio.api.reportesincidentes.model.Incidente;
import com.javaintermedio.api.reportesincidentes.model.IncidenteResuelto;
import com.javaintermedio.api.reportesincidentes.repository.IncidenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service 
public class IncidenteService {
    
    @Autowired
    private IncidenteRepository incidenteRepo;
    
    @Autowired
    private IncidentesResueltosService incidenteResueltoService;
    
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
    
    public void modificarIncidente(long id, Incidente incidente){
        
        if (Objects.nonNull(incidente.getFechaSolucion())){
            IncidenteResuelto incidenteResuelto = new IncidenteResuelto();
            
            incidenteResuelto.setDescripcionProblema(incidente.getDescripcionProblema());
            incidenteResuelto.setIdTecnico(incidente.getIdTecnico());
            incidenteResuelto.setFechaRegistro(incidente.getFechaRegistro());
            incidenteResuelto.setFechaEstimadaSolucion(incidente.getFechaEstimadaSolucion());
            incidenteResuelto.setFechaSolucion(incidente.getFechaSolucion());
            
            this.incidenteRepo.deleteById(id);
            this.incidenteResueltoService.agregarIncidente(incidenteResuelto);
        }
        else{
            Incidente incidenteAux = this.incidenteRepo.findById(id).orElse(null);
            
            incidenteAux.setDescripcionProblema(incidente.getDescripcionProblema());
            incidenteAux.setIdTecnico(incidente.getIdTecnico());
            incidenteAux.setFechaRegistro(incidente.getFechaRegistro());
            incidenteAux.setFechaEstimadaSolucion(incidente.getFechaEstimadaSolucion());
            
            this.incidenteRepo.save(incidenteAux);
        }
    }
}
