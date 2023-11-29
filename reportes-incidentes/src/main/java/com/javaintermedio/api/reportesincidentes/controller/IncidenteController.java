package com.javaintermedio.api.reportesincidentes.controller;

import com.javaintermedio.api.reportesincidentes.model.Incidente;
import com.javaintermedio.api.reportesincidentes.service.IncidenteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidenteController {
    
    private IncidenteService incidente;
    
    @Autowired
    public IncidenteController(IncidenteService incidente){
        this.incidente = incidente;
    }
    
    //CRUD basico
    @GetMapping(value = "/reportes-incidentes/incidentes", headers="Accept=application/json") 
    @ResponseBody
    public List <Incidente> mostrarIncidente(){
        return this.incidente.mostrarTodos();
    }
    
    @PostMapping (value = "/reportes-incidentes/incidentes/agregar", headers="Accept=application/json")
    public String agregarIncidente (@RequestBody Incidente incidente){
        this.incidente.agregarIncidente(incidente);
        return "Incidente creado";
    }
    
    @GetMapping (value = "/reportes-incidentes/incidentes/{id}", headers="Accept=application/json")
    @ResponseBody
    public Optional<Incidente> mostrarIncidente (@PathVariable long id){
        return this.incidente.buscarIncidente(id);
    }
    
    @PutMapping (value = "/reportes-incidentes/incidentes/actualizar/{id}", headers="Accept=application/json")
    public void modificarIncidente (@PathVariable long id, @RequestBody Incidente incidente){
        this.incidente.modificarIncidente(id, incidente);
    }
    
    @DeleteMapping (value = "/reportes-incidentes/incidentes/eliminar/{id}", headers="Accept=application/json")
    public void eliminarIncidente (@PathVariable long id){
        this.incidente.eliminarIncidente(id);
    }
}
